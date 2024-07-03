package Day1;

public class minmaxstack {
        private int[] arr;
        private int top;

        public minmaxstack(int size) {
            arr = new int[size];
            top = -1;
        }

        public void push(int value) {
            if (top == arr.length - 1) {
                System.out.println("Stack is already full");
            } else {
                top++;
                arr[top] = value;
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


        public int pop() {
            if (top == -1) {
                System.out.println("Stack Underflow");
                return -1; // Or throw an exception
            } else {
                int poppedValue = arr[top];
                top--;
                return poppedValue;
            }
        }

        public int peek() {
            if (top == -1) {
                System.out.println("Stack is empty");
                return -1; // Or throw an exception
            } else {
                return arr[top];
            }
        }

        public boolean isEmpty() {
            return top == -1;
        }

    public int getMin() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            int min = arr[top];
            for (int i = top; i >= 0; i--) {
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            return min;
        }
    }
    public int getMax() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            int max = arr[top];
            for (int i = top; i >= 0; i--) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            return max;
        }
    }


        public static void main(String[] args) {

            minmaxstack stack = new minmaxstack(5);
            System.out.println("Is Day1.stack empty...?" + stack.isEmpty());
            System.out.println("Input some integers into Day1.stack");
            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.push(40);
            stack.push(50);

            System.out.println("Stack is like...");
            stack.show();

            System.out.println("Pop element from Day1.stack...");
            stack.pop();
            stack.pop();
            System.out.println("Stack after pop elements");
            stack.show();

            System.out.println("Element of Day1.stack after pop is- ");
            System.out.println(" " + stack.peek());

            System.out.println("Check status of Day1.stack..." + stack.isEmpty());

            System.out.println("Stack is ... ");
            stack.show();

            System.out.println(" Find minimum value ");
            System.out.println(" \n" +stack.getMin());
            System.out.println(" Find maximum value ");
            System.out.println(" \n" +stack.getMax());



        }
    }

