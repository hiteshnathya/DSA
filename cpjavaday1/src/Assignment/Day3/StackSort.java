package Assignment.Day3;

import java.util.Stack;

public class StackSort {
    public static void sortStack(Stack<Integer> stack) {
            Stack<Integer> tempStack = new Stack<>();
        System.out.println(" Sorting Stack >>>");

            while (!stack.isEmpty()) {
                int temp = stack.pop();
                System.out.println("Popped " + temp + " from original stack");
                System.out.println();
                System.out.println("Temp Stack: " + tempStack);


                while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                    stack.push(tempStack.pop());
                    System.out.println("Popped from temp stack and pushed to original stack");
                    System.out.println("Original Stack: " + stack);
                    System.out.println("Temp Stack: " + tempStack);

                }
                System.out.println();
                tempStack.push(temp);
                System.out.println("Pushed " + temp + " to temp stack");
                System.out.println("Popped from temp stack and pushed to original stack");
                System.out.println("Original Stack: " + stack);
                System.out.println("Temp Stack: " + tempStack);
            }

            // Transfer elements back to original stack (now sorted)
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
        }

        public static void main(String[] args) {
            Stack<Integer> stack = new Stack<>();
            stack.push(5);
            stack.push(3);
            stack.push(1);
            stack.push(2);
            stack.push(4);

            System.out.println("Original Stack: " + stack);
            sortStack(stack);
            System.out.println("Sorted Stack: " + stack);
        }
    }



