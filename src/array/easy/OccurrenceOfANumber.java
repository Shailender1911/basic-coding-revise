package array.easy;

import java.util.HashMap;

public class OccurrenceOfANumber {

    private int countOccurrences(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0; // Safe check
        }

        HashMap<Integer, Integer> numberCountMap = new HashMap<>();

        for (int num : arr) {
            numberCountMap.put(num, numberCountMap.getOrDefault(num, 0) + 1);
        }

        return numberCountMap.getOrDefault(k, 0);
    }

    public static void main(String[] args) {
        int[] arr = {100, 5, 10, 15, 20, 10, 5, 20, 30};
        int target = 10;

        OccurrenceOfANumber obj = new OccurrenceOfANumber();
        int count = obj.countOccurrences(arr, target);

        System.out.println("The occurrence for number = " + target + " is = " + count);
    }
}
