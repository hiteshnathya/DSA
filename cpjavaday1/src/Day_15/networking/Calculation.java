package Day_15.networking;

import java.io.Serializable;

public class Calculation implements Serializable {
    private int x;
    private int y;
    private String Operation;

    // Constructor
    public Calculation(int x, int y, String operation) {
        this.x = x;
        this.y = y;
        this.Operation = operation;
    }

    // Getters and Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getOperation() {
        return Operation;
    }

    public void setOperation(String operation) {
        this.Operation = operation;
    }
}