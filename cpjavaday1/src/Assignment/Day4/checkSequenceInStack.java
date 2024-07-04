package Assignment.Day4;

import java.util.Stack;

public class checkSequenceInStack {

    public static boolean checkSequenceInStack(Stack<Integer> stack ,int[]sequence)
    {
        //creating method for check sequence is present in stack or not

        int Index = 0;
        System.out.println("Checking sequence in stack...");

        while (!stack.isEmpty())
        {
            System.out.println("\nStack: " + stack);
            System.out.println("Sequence Index: " + Index);

            if (Index < sequence.length && stack.peek() == sequence[Index])
                //Looks at the object at the top of this stack without removing it from the stack.
            {
                System.out.println("Match found: " + stack.peek() + " == " + sequence[Index]);

                Index++;
                stack.pop();
                //Removes the object at the top of this stack and returns that object as the value of poop

            }
            else {
                System.out.println("No match found. Break the loop.");
                break;
            }
            return Index == sequence.length;
        }
        return true;
    }
    public static void main(String[] args)
    {
        int[] sequence={ 5 , 4 , 3};

        Stack<Integer> stack=new Stack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(0);

        System.out.println("Stack: " + stack);
        System.out.println("Sequence: " + java.util.Arrays.toString(sequence));
        System.out.println("Is sequence present in stack ? \n" + checkSequenceInStack(stack, sequence));


    }

}
