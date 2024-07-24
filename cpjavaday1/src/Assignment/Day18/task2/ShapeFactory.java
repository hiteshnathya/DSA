package Assignment.Day18.task2;

// Step 1: Define the abstract product class Shape
abstract class Shape {
    abstract void draw();
}

// Step 2: Define concrete product classes Circle, Square, and Rectangle
class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Square extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Square");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

// Step 3: Define the ShapeFactory class
class ShapeFactory {
    // Factory method to create a shape object
    public static Shape createShape(String shapeType) {
        System.out.println("ShapeFactory: Creating a shape of type " + shapeType);
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }
        return null;
    }

    // Step 4: Use the factory method to create shapes
    public static void main(String[] args) {
        System.out.println("Main: Starting the shape creation process...");

        // Create a Circle using the ShapeFactory
        System.out.println("Main: Creating a Circle...");
        Shape circle = ShapeFactory.createShape("CIRCLE");
        System.out.println("Main: Circle created. Drawing the Circle...");
        circle.draw(); // Output: Drawing a Circle

        System.out.println();

        // Create a Square using the ShapeFactory
        System.out.println("Main: Creating a Square...");
        Shape square = ShapeFactory.createShape("SQUARE");
        System.out.println("Main: Square created. Drawing the Square...");
        square.draw(); // Output: Drawing a Square

        System.out.println();

        // Create a Rectangle using the ShapeFactory
        System.out.println("Main: Creating a Rectangle...");
        Shape rectangle = ShapeFactory.createShape("RECTANGLE");
        System.out.println("Main: Rectangle created. Drawing the Rectangle...");
        rectangle.draw(); // Output: Drawing a Rectangle

        System.out.println("Main: Shape creation process completed.");
    }
}