package Day_13.Reflaction;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class orange{
    public void color(){
        System.out.println(" Orange in color ");

    }
    public  void taste(){
        System.out.println("Tangy in Taste");
    }
}


public class ReflactionMethodEx {
    public static void main(String[] args) {
        orange ob=new orange();
        Class obj=ob.getClass();
        Method[] m=obj.getDeclaredMethods();
        for (Method m1: m) {
            System.out.println(" Method Name :" + m1.getName());

            System.out.println(" Return type : " + m1.getReturnType());
        }
        int modifier=obj.getModifiers();

        System.out.println(" Modifiers :"+ Modifier.toString(modifier));

    }

}
