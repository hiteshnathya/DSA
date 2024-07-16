package Day_13.Generics;

public class BoundedEx
{
    public <T extends Number> void display(T num)
    {
        System.out.println(num);
    }
    public static void main(String args[])
    {
        BoundedEx obj = new BoundedEx();
        obj.display(123890.45789); // double value
        obj.display(12345); // int
        obj.display((float)12.45); // float
        obj.display(12);// int
    }
}

