package Day_14.Lambda.Functionalinterface;

import java.util.function.Supplier;

public class SupplierEx {
    public static void main(String[] args) {
        //creating reffrence of supplier
        Supplier<Double> result=Math::random;
        System.out.println(result.get());


    }
}
