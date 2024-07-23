package Day_18.sdp;

public class SocketImplAdapter extends Socket implements SocketAdapter
{
    // Method to get a Volt object with a voltage of 120
    public Volt get120Volt()
    {
        // Calling the getVolt() method of the Socket class
        return getVolt(); // returns Volt object of 120 volts
    }

    // Method to get a Volt object with a voltage of 12
    public Volt get12Volt()
    {
        // Calling the getVolt() method of the Socket class
        Volt v = getVolt(); // returns Volt object of 120 volts
        // Converting the voltage to 12 using the convert method
        return convert(v, 10); // returns Volt object of 12
    }

    // Method to get a Volt object with a voltage of 3
    public Volt get3Volt()
    {
        // Calling the getVolt() method of the Socket class
        Volt v = getVolt(); // returns Volt object of 120 volts
        // Converting the voltage to 3 using the convert method
        return convert(v, 40); // returns Volt object of 3
    }

    // Method to convert a Volt object to a desired voltage
    public Volt convert(Volt v, int i)
    {
        // Creating a new Volt object with the converted voltage
        return new Volt(v.getVolts() / i);
    }
}