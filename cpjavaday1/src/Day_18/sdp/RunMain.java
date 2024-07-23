package Day_18.sdp;

public class RunMain {
    public static void main(String[] args) {
        // Creating an instance of the SocketImplAdapter class
        SocketImplAdapter adapter = new SocketImplAdapter();

        // Getting a Volt object with a voltage of 120
        Volt volt120 = adapter.get120Volt();
        // Getting a Volt object with a voltage of 12
        Volt volt12 = adapter.get12Volt();
        // Getting a Volt object with a voltage of 3
        Volt volt3 = adapter.get3Volt();

        // Printing the voltage values to the console
        System.out.println("120 Volt: " + volt120.getVolts());
        System.out.println("12 Volt: " + volt12.getVolts());
        System.out.println("3 Volt: " + volt3.getVolts());
    }
}
