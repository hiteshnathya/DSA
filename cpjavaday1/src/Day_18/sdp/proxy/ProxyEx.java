// Define an interface for the expensive object
interface ExpensiveObject {
    void process();
}

// Implementation of the expensive object
class ExpensiveObjectImpl implements ExpensiveObject {
    // Constructor that performs heavy initial configuration
    public ExpensiveObjectImpl() {
        heavyInitialConfiguration();
    }

    // Method that performs heavy initial configuration
    public void heavyInitialConfiguration() {
        System.out.println("Loading in initial heavy configuration");
    }

    // Method that performs the actual processing
    public void process() {
        System.out.println("Processing done");
    }
}

// Proxy class that acts as a surrogate for the expensive object
class ExpensiveObjectProxy implements ExpensiveObject {
    // Static instance of the expensive object (lazy initialization)
    public static ExpensiveObjectImpl ob;

    // Process method that delegates to the expensive object
    public void process() {
        // Check if the expensive object is null, if so, create a new instance
        if (ob == null) {
            ob = new ExpensiveObjectImpl();
        }
        // Delegate the process method to the expensive object
        ob.process();
    }
}

public class ProxyEx {
    public static void main(String[] args) {
        // Create a proxy object that acts as a surrogate for the expensive object
        ExpensiveObject o = new ExpensiveObjectProxy();

        // First call to process, which will initialize the expensive object
        o.process(); // initializing

        // Second call to process, which will reuse the already initialized expensive object
        o.process(); // already initialization done
    }
}