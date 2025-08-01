# Best Time to Buy and Sell Stock

## Problem Statement
Given an array `prices` where `prices[i]` is the price of a stock on the `i`th day, maximize your profit by choosing a single day to buy and a different day in the future to sell. Return the maximum profit achievable, or `0` if no profit is possible.

**Example:**
- **Input:** `prices = [7,1,5,3,6,4]`
- **Output:** `5`
- **Explanation:** Buy on day 2 (price = 1), sell on day 5 (price = 6), profit = 6-1 = 5.

## Approach
The optimal approach uses a **single pass**, tracking the minimum price seen so far and the maximum profit possible by selling at each price. This achieves O(n) time and O(1) space.

### Why Single Pass?
- Avoids checking all pairs (O(n²)).
- Efficiently updates minimum price and profit in one iteration.

## Pseudocode
```
1. Initialize minPrice = prices[0], maxProfit = 0.
2. For each price in prices[1...n-1]:
   a. Update minPrice = min(minPrice, price).
   b. Update maxProfit = max(maxProfit, price - minPrice).
3. Return maxProfit.
```

## Java Solution
```java
/**
 * Solution for the Best Time to Buy and Sell Stock problem.
 */
public class BestTimeToBuyAndSellStock {

    /**
     * Finds the maximum profit from buying and selling a stock once.
     *
     * @param prices Array of stock prices.
     * @return Maximum profit possible, or 0 if none.
     * @throws IllegalArgumentException If prices is null or empty.
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit: " + solution.maxProfit(prices)); // 5
    }
}
```

## Explanation of the Code
1. **Input Validation**: Returns 0 for null or arrays with fewer than 2 elements.
2. **Min Price Tracking**: Updates `minPrice` with the lowest price seen.
3. **Profit Update**: Computes potential profit for each price.
4. **Edge Cases**: Handles decreasing prices (returns 0) and small arrays.
5. **Single Pass**: Processes each price once.

## Time Complexity (TC)
- **O(n)**: Single pass through the array.
- Where `n` is the length of the input array.

## Space Complexity (SC)
- **O(1)**: Uses only two variables.

## Common Interview Questions
1. **What if prices always decrease?**
   - Return 0, as no profit is possible.
2. **Can we sell before buying?**
   - No, the problem requires buying before selling.
3. **What if we can make multiple transactions?**
   - That’s a different problem (Best Time to Buy and Sell Stock II).
4. **How do you handle single-day arrays?**
   - Return 0, as buying and selling require different days.
5. **Can we use two pointers?**
   - Not directly, but the min-price approach is more efficient.

## Tips for Interviews
- **Explain Intuition**: Show how min-price tracking avoids O(n²).
- **Use Example**: Walk through [7,1,5,3,6,4] to demonstrate.
- **Discuss Edge Cases**: Mention decreasing prices and small arrays.
- **Mention Variations**: Briefly note multiple-transaction versions.