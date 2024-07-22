package Assignment.Day17.task3;

public class StringUtility {
    public static String reverseString(String input) {
        if (input == null) {
            return null;
        }
        return new StringBuilder(input).reverse().toString();
    }

    public static boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        String reversed = reverseString(input);
        return input.equals(reversed);
    }

    public static String concatenateStrings(String[] strings) {
        if (strings == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        for (String str : strings) {
            result.append(str);
        }
        return result.toString();
    }
}