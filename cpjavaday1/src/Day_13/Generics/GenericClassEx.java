package Day_13.Generics;

class Box<T>
{
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}


public class GenericClassEx
{
    public static void main(String args[])
    {
        // Object of Box class with string data
        Box<String> obj = new Box<>();
        obj.setT("Java");
        System.out.println(obj.getT());


        // Object of Box class with Integer data
        Box<Integer> obj1 = new Box<>();
        obj1.setT(1234);
        System.out.println(obj1.getT());
    }
}


//Generics
//Generics in Java is one of the powerful
// feature which enhances Type Safety and hence reduces the need of Type casting.
//Type Safety Reduces the need of ClasscastException and other type related errors.
