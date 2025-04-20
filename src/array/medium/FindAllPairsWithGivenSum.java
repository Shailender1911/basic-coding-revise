package array.medium;

import java.util.*;

public class FindAllPairsWithGivenSum {

    private List<List<Integer>> findAllPairs(int[] a, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        Set<String> uniquePairs = new HashSet<>();

        for (int num : a) {
            int complement = target - num;

            if (seen.contains(complement)) {
                int first = Math.min(num, complement);
                int second = Math.max(num, complement);
                String pairKey = first + ":" + second;

                if (!uniquePairs.contains(pairKey)) {
                    result.add(Arrays.asList(first, second));
                    uniquePairs.add(pairKey);
                }
            }

            seen.add(num);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 5, 15, 10, 20};
        int target = 25;

        FindAllPairsWithGivenSum obj = new FindAllPairsWithGivenSum();
        List<List<Integer>> pairs = obj.findAllPairs(a, target);

        System.out.println("Pairs with sum " + target + ": " + pairs);
    }
}
