package P01_BalancedBrackets;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java P01_BalancedBrackets.Main <filename>");
            return;
        }
        String filename = args[0];
        try {
            String fileContent = loadFileAsString(filename);
            if (isBalanced(fileContent)) {
                System.out.println("The brackets in the file are balanced.");
            } else {
                System.out.println("The brackets in the file are not balanced.");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    /**
     * Checks if the input string has balanced brackets.
     *
     * @param str The string to check for balanced brackets.
     * @return true if the brackets are balanced, false otherwise.
     */
    public static boolean isBalanced(String str) {
        // Create a stack to keep track of open parentheses
        // Side note: Oracle recommends using ArrayDeque for stack operations since it is more efficient than Stack.
        ArrayDeque<Character> openParenStack = new ArrayDeque<>();
        // Iterate through each character in the string
        for (var c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                openParenStack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (openParenStack.isEmpty()) return false;
                if (((c == ')') && openParenStack.peek() == '(') ||
                        ((c == '}') && openParenStack.peek() == '{') ||
                        ((c == ']') && openParenStack.peek() == '[')) {
                    openParenStack.pop();
                } else return false;
            }

        }
        // If the stack is empty, all open parentheses were matched
        return openParenStack.isEmpty();
    }
    public static String loadFileAsString(String filename) throws IOException {
        Path filePath = Paths.get(filename);
        String fileContent;
        try {
            fileContent = java.nio.file.Files.readString(filePath);
        } catch (IOException e) {
            throw new IOException("Error reading file: " + filename, e);
        }
        return fileContent;
    }
}
