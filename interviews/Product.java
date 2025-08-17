import java.util.*;
import java.util.stream.Collectors;

// Represents a product sale event
class Product {
    private String eventId;
    private Integer productId;
    private String timeStamp; // Using String to match problem's format; could use Date if needed

    public Product(String eventId, Integer productId, String timeStamp) {
        this.eventId = eventId;
        this.productId = productId;
        this.timeStamp = timeStamp;
    }

    public Integer getProductId() {
        return productId;
    }
}

// Processes events and tracks top N sold products
class Solution {
    private Map<Integer, Integer> productCount;

    public Solution() {
        productCount = new HashMap<>();
    }

    // Process a single product event
    public void processEvent(Product product) {
        Integer productId = product.getProductId();
        productCount.put(productId, productCount.getOrDefault(productId, 0) + 1);
    }

    // Return top N product IDs by sales count
    public Integer[] topN(List<Product> products, int topCount) {
        if (topCount < 0) {
            throw new IllegalArgumentException("topCount must be non-negative");
        }

        // Process all products if not already processed
        for (Product product : products) {
            processEvent(product);
        }

        // Sort entries by count (descending) and productId (ascending) for ties
        List<Map.Entry<Integer, Integer>> sortedEntries = productCount.entrySet()
                .stream()
                .sorted((a, b) -> {
                    int countComparison = b.getValue().compareTo(a.getValue());
                    return countComparison != 0 ? countComparison : a.getKey().compareTo(b.getKey());
                })
                .collect(Collectors.toList());

        // Collect top N product IDs
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < Math.min(topCount, sortedEntries.size()); i++) {
            result.add(sortedEntries.get(i).getKey());
        }

        return result.toArray(new Integer[0]);
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Create events matching the problem's example
        List<Product> products = new ArrayList<>();
        products.add(new Product("e1", 123, "20211208 00:00:00")); // T1
        products.add(new Product("e2", 456, "20211208 00:00:01")); // T2
        products.add(new Product("e3", 456, "20211208 00:00:02")); // T3
        products.add(new Product("e4", 786, "20211208 00:00:03")); // T4
        products.add(new Product("e5", 123, "20211208 00:00:04")); // T5
        products.add(new Product("e6", 456, "20211208 00:00:05")); // T6

        // Test topN
        Integer[] top1 = solution.topN(products, 1);
        System.out.println("Top 1: " + Arrays.toString(top1)); // Expected: [456]

        Integer[] top2 = solution.topN(products, 2);
        System.out.println("Top 2: " + Arrays.toString(top2)); // Expected: [456, 123]
    }
}