package Day_18.cdp;


interface Fruit {
    void properties();

}

class Apple implements Fruit {
    public void properties() {
        System.out.println("Red in color + Sweet in Test");
    }
}

class Orange implements Fruit {
    public void properties() {
        System.out.println("orange in color + Tangy  in Test");
    }
}

class Mango implements Fruit {
    public void properties() {
        System.out.println("Yellow in color + Sweet in Test");
    }
}

public class FactoryPattern {
    public Fruit createFruit(String types) {
        if (types.equals("Apple"))
            return new Apple();
        else if (types.equals("Orange"))
            return new Orange();
        else if (types.equals("Mango"))
            return new Mango();
        else
            return (Fruit) new IllegalAccessException("Unknown fruit type :" + types);
    }

    public static void main(String[] args) {

        FactoryPattern obj = new FactoryPattern();
        Fruit apple = obj.createFruit("Apple");
        apple.properties();
        Fruit orange = obj.createFruit("Orange");
        orange.properties();
        Fruit mango = obj.createFruit("Mango");
        mango.properties();
    }
}
