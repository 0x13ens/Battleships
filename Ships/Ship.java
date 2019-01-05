public class Ship {
    public int size;
    boolean isAlive;
    String name;

    /* Why do we use private here? Well, if someone wanted to know your name, they should ask you directly, instead of
    reaching into your pocket and pulling out your Social Security card. This private does something like that: it
    prevents outside entities from accessing your variables. You can only return private members through getter
    functions (shown below). */

    public Ship() {
        this.name = name;
        this.isAlive = true;
        this.size = 5;
    }

    public void setSize( int aDifferentSize)
    {
        size = aDifferentSize;
    }

    /* let's define our getter functions here */
    public String getName() { // what is your name?
    return this.name; // my name is ...
    }
   
    public int getSize() { // what is your size?
    return this.size; // my size is ...
    }
   
    public boolean getisAlive() { // Are you still alive yes/no?
    return this.isAlive; // Yes/no I'm still alive
    }
}