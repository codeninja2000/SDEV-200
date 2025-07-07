package P02_CountKeywordsV2;

import java.util.*;
import java.io.*;

/**
 * Program takes a Java source file as input and counts the number of keywords in the file.
 * The keywords considered are all Java keywords plus true, false, and null.
 * It ignores comments and string literals.
 * The program reads the file word by word, checking each word against a set of keywords.
 * If a word is a keyword, it increments the count.
 */
public class CountKeywordsV2 {
    public static void main(String[] args) {
//
        if (args.length != 1) {
            System.out.println("Usage: java P02_CountKeywordsV2.CountKeywordsV2 <filename>");
            return;
        }
        String filename = args[0];
//
        File file = new File(filename);
        if (file.exists()) {
            try {
                System.out.println("The number of keywords in " + filename
                        + " is " + countKeywords(file));
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("File " + filename + " does not exist");
        }
    }

    /**
     * Counts the number of Java keywords in a given file.
     *
     * @param file The file to count keywords in.
     * @return The number of keywords found in the file.
     * @throws IOException If an error occurs while reading the file.
     */
    public static int countKeywords(File file) throws IOException {
        // Array of all Java keywords + true, false and null
        String[] keywordString = {"abstract", "assert", "boolean",
                "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum",
                "extends", "for", "final", "finally", "float", "goto",
                "if", "implements", "import", "instanceof", "int",
                "interface", "long", "native", "new", "package", "private",
                "protected", "public", "return", "short", "static",
                "strictfp", "super", "switch", "synchronized", "this",
                "throw", "throws", "transient", "try", "void", "volatile",
                "while", "true", "false", "null"};

        try {
            // Call the private method to get the count of keywords
            return getCount(file, keywordString);
        } catch (FileNotFoundException e) {

            System.out.println("File not found: " + file.getAbsolutePath());
            throw e;

        }


    }

    /**
     * Counts the number of keywords in a file.
     *
     * @param file The file to count keywords in.
     * @param keywordString An array of keywords to count.
     * @return The number of keywords found in the file.
     * @throws FileNotFoundException If the file does not exist.
     */
    private static int getCount(File file, String[] keywordString) throws FileNotFoundException {
        Set<String> keywordSet =
                new HashSet<>(Arrays.asList(keywordString));
        int count = 0;

        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String word = input.next();
            // Exclude single-line comments
            if (word.equals("//")) {
                input.nextLine();
            }
            // Exclude string
            else if (word.contains("\"")) {
                String nextWord;
                do {
                    nextWord = input.next();
                } while (!nextWord.contains("\""));

            }
            // Exclude multi-line comments
            else if (word.contains("/*")) {
                String nextWord;
                do {
                    nextWord = input.next();
                } while (!nextWord.contains("*/"));
            }
            else if (keywordSet.contains(word))
                count++;
        }
        return count;
    }
}
