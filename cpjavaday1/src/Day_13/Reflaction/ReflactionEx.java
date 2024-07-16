package Day_13.Reflaction;

import java.lang.reflect.Modifier;

class fruit {

}

class apple extends fruit {
    public void color() {
        System.out.println(" Apple --> Red in color ");
    }
}

public class ReflactionEx {
    public static void main(String[] args) {
        apple obj = new apple();
        Class ob = obj.getClass();
        String st = ob.getName();
        System.out.println("Name of the class : " + st);
        int modifier = ob.getModifiers();
        String s1 = Modifier.toString(modifier);
        System.out.println("Modifier :" + s1);
        Class sc = ob.getSuperclass();
        System.out.println("Super class : " + sc.getName());

    }


}
//
//Java Reflection and Annotations
//Java Reflection is a mechanisim that allows to introspect variables, methods , constructors and classes at runtime without knowing their names at compile time.
//
//Accessing Class Object( First create object of “Class”)
//1.	getClass() from the object of a class
//2.	Class.forName() – this method  with full name of the class.
//        3.	 .class

