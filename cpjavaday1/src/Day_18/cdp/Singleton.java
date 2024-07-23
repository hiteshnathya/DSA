package Day_18.cdp;

public class Singleton {
    private static Singleton obj;
    private Singleton() {
    }
    public static Singleton getInstance() {
        if (obj == null) {
            obj = new Singleton();
        }
        return obj;
    }
    public static void main(String[] args) {
        Singleton instance = new Singleton();
        System.out.println("Singleton instance " + instance);
        Singleton in = Singleton.getInstance();
        System.out.println("Singleton instance " + in);
    }
}
