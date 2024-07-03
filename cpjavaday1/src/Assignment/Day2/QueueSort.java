package Assignment.Day2;


    import java.util.LinkedList;
import java.util.Stack;

    public class QueueSort {
        public static void sortByStack(LinkedList<Integer> queue) {
                Stack<Integer> stack = new Stack<>();

                while (!queue.isEmpty()) {
                    int dequeued = queue.poll();

                    // Print intermediate steps
                    System.out.println("Dequeued: " + dequeued);

                    while (!stack.isEmpty() && dequeued > peek(stack)) {
                        int temp = pop(stack);  // Pop element from stack
                        queue.add(temp);        // Add popped element back to queue end

                        // Print intermediate steps
                        System.out.println("Pushed back to queue: " + temp);
                    }

                    push(stack, dequeued);  // Push dequeued element to stack

                    // Print intermediate steps
                    System.out.println("Pushed to stack: " + dequeued);
                }

                while (!stack.isEmpty()) {
                    queue.addLast(pop(stack));  // Pop from stack and add to queue end (sorting)
                }
            }

            // Helper methods to separate pop, push, and peek operations
            public static int pop(Stack<Integer> stack) {
                if (stack.isEmpty()) {
                    throw new IllegalStateException("Stack is empty");
                }
                return stack.pop();
            }

            public static void push(Stack<Integer> stack, int element) {
                stack.push(element);
            }

            public static int peek(Stack<Integer> stack) {
                if (stack.isEmpty()) {
                    throw new IllegalStateException("Stack is empty");
                }
                return stack.peek();
            }

            public static void main(String[] args) {
                LinkedList<Integer> queue = new LinkedList<>();
                queue.add(3);
                queue.add(1);
                queue.add(4);
                queue.add(2);

                System.out.println("Original queue: " + queue);

                sortByStack(queue);

                System.out.println("Sorted queue: " + queue);
            }
        }



