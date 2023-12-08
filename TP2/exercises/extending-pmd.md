# Extending PMD

Use XPath to define a new rule for PMD to prevent complex code. The rule should detect the use of three or more nested `if` statements in Java programs so it can detect patterns like the following:

```Java
if (...) {
    ...
    if (...) {
        ...
        if (...) {
            ....
        }
    }

}
```
Notice that the nested `if`s may not be direct children of the outer `if`s. They may be written, for example, inside a `for` loop or any other statement.
Write below the XML definition of your rule.

You can find more information on extending PMD in the following link: https://pmd.github.io/latest/pmd_userdocs_extending_writing_rules_intro.html, as well as help for using `pmd-designer` [here](https://github.com/selabs-ur1/VV-ISTIC-TP2/blob/master/exercises/designer-help.md).

Use your rule with different projects and describe you findings below. See the [instructions](../sujet.md) for suggestions on the projects to use.

## Answer

Here is my XML rule :

```xml
<rule name="No3If"
      language="java"
      message="There is at least 3 nested Ifs !"
      class="net.sourceforge.pmd.lang.rule.XPathRule">
   <description>

   </description>
   <priority>3</priority>
   <properties>
      <property name="version" value="3.1"/>
      <property name="xpath">
         <value>
            <![CDATA[
            //IfStatement[.//IfStatement[.//IfStatement]]
            ]]>
         </value>
      </property>
   </properties>
</rule>
```

This rule checks if there are three nested If statements.
This is supposedly because if you have more than three nested "if", you should instead use a switch case.

I used the rule on the java collections with the check command from pmd.
The result I got was a bit troubling at first, because it pinged errors where there are many "if{} else if{}".
But after I thought about it, it is indeed a form of nested if statements. 
Because the "if" right after the "else" is considered as an "if" inside another "if".

The rule also pings the right amount of "if" that don't respect the nested criteria.
It doesn't ping the last two "if".