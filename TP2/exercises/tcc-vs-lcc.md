# TCC *vs* LCC

Explain under which circumstances *Tight Class Cohesion* (TCC) and *Loose Class Cohesion* (LCC) metrics produce the same value for a given Java class. Build an example of such as class and include the code below or find one example in an open-source project from Github and include the link to the class below. Could LCC be lower than TCC for any given class? Explain.

## Answer

TCC and LCC produce the same value when there are only direct connections 
between methods within the class, and no indirect connections.

An example of such a class could be :

````Java
public class example{
    public void setA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    private int a;

}
````
Here, TCC is 1 and LCC is 1 since all methods are directly connected and there is no indirect connections.

LCC can never be lower than TCC since TCC only considers direct 
connections and LCC considers both direct and indirect connections.
LCC is at minimum equal to TCC, when all connections in the class are direct.