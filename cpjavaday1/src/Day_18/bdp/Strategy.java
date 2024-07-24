// Import necessary Java classes
import java.util.ArrayList;
import java.util.List;

// Define the Product class, which represents a product with an ID and a price
class Product {
    // Declare private variables to store product ID and price
    private String id;
    private double prize; // Note: It's more common to use "price" instead of "prize"

    // Constructor to create a new Product object
    public Product(String id, double prize) {
        // Initialize product ID and price
        this.id = id;
        this.prize = prize;
    }

    // Getter method to retrieve the price of the product
    public double getPrize() {
        // Return the price of the product
        return prize;
    }
}

// Define the PaymentGateway interface, which declares a payment method
interface PaymentGateway {
    // Method to process a payment of a specified amount
    void payment(double amt);
}

// Implement the PaymentGateway interface for CreditCard
class CreditCard implements PaymentGateway {
    // Declare private variables to store credit card number and name
    private int cardNo;
    private String name;

    // Constructor to create a new CreditCard object
    public CreditCard(int cardNo, String name) {
        // Initialize credit card number and name
        this.cardNo = cardNo;
        this.name = name;
    }

    // Implementation of the payment method for CreditCard
    @Override
    public void payment(double amt) {
        // Print a message indicating payment done by credit card
        System.out.println("Payment of " + amt + " done by credit card.");
    }
}

// Implement the PaymentGateway interface for CashOnDelivery
class CashOnDelivery implements PaymentGateway {
    // Declare private variable to store delivery address
    private String address;

    // Constructor to create a new CashOnDelivery object
    public CashOnDelivery(String address) {
        // Initialize delivery address
        this.address = address;
    }

    // Implementation of the payment method for CashOnDelivery
    @Override
    public void payment(double amt) {
        // Print a message indicating payment done by cash on delivery
        System.out.println("Payment of " + amt + " done by cash on delivery at " + address + ".");
    }
}

// Define the Shopping class, which represents a shopping bag
class Shopping {
    // Declare a private list to store products in the shopping bag
    private List<Product> products = new ArrayList<>();

    // Method to add a product to the shopping bag
    public void addProduct(Product p) {
        // Add the product to the list
        products.add(p);
    }

    // Method to remove a product from the shopping bag
    public void removeProduct(Product p) {
        // Remove the product from the list
        products.remove(p);
    }

    // Method to calculate the total price of all products in the shopping bag
    public double calculatePrice() {
        // Use Java 8's stream API to sum up the prices of all products
        return products.stream().mapToDouble(Product::getPrize).sum();
    }

    // Method to pay for the products in the shopping bag using a payment method
    public void pay(PaymentGateway paymentMethod) {
        // Calculate the total price of the products
        double price = calculatePrice();
        // Use the payment method to pay for the products
        paymentMethod.payment(price);
    }
}

// Main class to demonstrate the strategy pattern
public class Strategy {
    // Main method to test the shopping bag and payment methods
    public static void main(String[] args) {
        // Create a new shopping bag
        Shopping bag = new Shopping();

        // Create two products
        Product p1 = new Product("111", 200);
        Product p2 = new Product("222", 500);

        // Add the products to the shopping bag
        bag.addProduct(p1);
        bag.addProduct(p2);

        // Pay for the products using CashOnDelivery
        bag.pay(new CashOnDelivery("Delhi"));

        // Pay for the products using CreditCard
        bag.pay(new CreditCard(12345, "Hitesh"));
    }
}