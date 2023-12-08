package fr.istic.vv;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.visitor.VoidVisitorWithDefaults;

import java.util.HashMap;
import java.util.HashSet;


// This class visits a compilation unit and
// prints all public enum, classes or interfaces along with their public methods
public class PublicElementsPrinter extends VoidVisitorWithDefaults<Void> {

    public HashSet<String> attributes;


    public HashSet<String> getters;
    public String className;

    public PublicElementsPrinter(){
        attributes= new HashSet<>();
        getters= new HashSet<>();
        className="";
    }
    @Override
    public void visit(CompilationUnit unit, Void arg) {
        for(TypeDeclaration<?> type : unit.getTypes()) {
            type.accept(this, null);
        }
    }

    /**
     * Print pour les types (class par exemple)
     * @param declaration
     * @param arg
     */
    public void visitTypeDeclaration(TypeDeclaration<?> declaration, Void arg) {
        if(!declaration.isPublic()) {System.out.println("Je suis privé");return;}
        System.out.println(declaration.getFullyQualifiedName().orElse("[Anonymous]"));
        for (int i = 0; i < declaration.getFields().size();i++){
            attributes.add(declaration.getFields().get(i).toString().substring(0,declaration.getFields().get(i).toString().indexOf(";")));
        }
        for(MethodDeclaration method : declaration.getMethods()) {
            method.accept(this, arg);
        }
        // Printing nested types in the top level
        for(BodyDeclaration<?> member : declaration.getMembers()) {
            if (member instanceof TypeDeclaration)
                member.accept(this, arg);
        }
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration declaration, Void arg) {
        System.out.println("Class or Interface");
        className=declaration.toString();
        visitTypeDeclaration(declaration, arg);
    }

    @Override
    public void visit(EnumDeclaration declaration, Void arg) {
        System.out.println("Enumeration");
        visitTypeDeclaration(declaration, arg);
    }

    /**
     * Print pour les méthodes
     * @param declaration
     * @param arg
     */
    @Override
    public void visit(MethodDeclaration declaration, Void arg) {
        if(!declaration.isPublic()) {System.out.println("Je suis privé");return;}
        String nameOfMethod = declaration.getDeclarationAsString(false,false);
        int positionOfSpace = nameOfMethod.indexOf(" ");
        if (nameOfMethod.substring(positionOfSpace+1,positionOfSpace+4).equals("get")){
            System.out.println("  //Je suis un getter !");
            getters.add(declaration.getDeclarationAsString());
        }
        System.out.println("  " + declaration.getDeclarationAsString(true, true));
    }

    public boolean isThereAFieldWithoutGetter (){
        if (getters.size()<attributes.size()) {System.out.println("Il y a moins de getters que d'attributs pour la classe "+className);return false;}
        for (String s : attributes){
            String firstLetter = ""+s.charAt(0);
            if (!getters.contains("get"+firstLetter.toUpperCase()+s.substring(1))){
                System.out.println("L'attribut "+s+" n'a pas de getter");
                return false;
            }
        }
        return true;
    }

}
