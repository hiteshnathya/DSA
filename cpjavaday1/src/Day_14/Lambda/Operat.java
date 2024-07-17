package Day_14.Lambda;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface Operat<T> {

//abstract method
    T calculate (T a , T b );
}

class  Operation{
    public static void main(String[] args) {
        Operat<Integer> rf=(a,b)->a+b;
        System.out.println(rf.calculate(2,5));
        Operat<Double> rf1=(a,b)->a+b;
        System.out.println(rf1.calculate(27.0,56.334));
        Operat<String> rf2=(a,b)->a+b;
        System.out.println(rf2.calculate("227","232"));

        List<String>l1=new ArrayList<>();
        l1.add("adsddwfd");
        l1.add("fekgfe");
        l1.add("dfefccf");
        l1.forEach(p ->{
            System.out.println(p);
        });


    }
}

