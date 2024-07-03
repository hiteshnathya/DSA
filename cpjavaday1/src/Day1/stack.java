package Day1;

public class stack {
    private String[] arr;
    private int top;


    public stack(int size) {
        arr = new String[size];
        top = -1;

    }

    public void push(String name) {

        if (top == arr.length - 1) {
            System.out.println(" Stack is already full");
        } else {
            top++;
            arr[top] = name;

        }
    }

    public void show() {

        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.print("Stack elements: ");
            for (int i = top; i >= 0; i--) {
                System.out.print(arr[i] + " \n");
            }
            System.out.println();
        }

    }

    public String pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
        } else {
            String popedname = arr[top];
            top--;
            return popedname;
        }

        return null;
    }

    public String peek() {
        if (top == -1) {
            System.out.println("Stack is empty");

        } else {
            return arr[top];
        }
        return null;
    }

    public boolean isempty() {

        return top == -1;
    }

    public static void main(String[] args) {

        stack stack = new stack(5);
        System.out.println(" Is Day1.stack empty ...?" + stack.isempty());
        System.out.println(" input some name into Day1.stack");
        stack.push("Hitesh");
        stack.push("naveen");
        stack.push("Ravi");
        stack.push("maddy");
        stack.push("Jass");

        System.out.println(" Stack is like ...");
        stack.show();

        System.out.println(" Pop element  from Day1.stack...");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println(" Day1.stack after pop elements");
        stack.show();

        System.out.println(" Element of Day1.stack after pop is- ");
        System.out.println(" " + stack.peek());

        System.out.println(" CKECK STATUS OF STACK ..." + stack.isempty());

        System.out.println(" Stack is ... ");
        stack.show();


    }
}
