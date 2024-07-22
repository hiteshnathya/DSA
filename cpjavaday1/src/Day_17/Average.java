package Day_17;


public class Average {

    public static void main(String[] args) {
        double average = find(args);
        System.out.println("Average " + average);
    }

    public static double find(String[] in) {

        double res = 0;
        for (String s : in) {
            res = res + Integer.parseInt(s);

        }
        return res;
    }
}
