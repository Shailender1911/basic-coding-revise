package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestWord {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("elephant", "tiger", "cat", "hippopotamus");

        String longestWord = words.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("No words found");

        System.out.println("Longest Word: " + longestWord);
    }
}
