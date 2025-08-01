# Word Search

## Problem Statement
Given an `m x n` grid of characters `board` and a string `word`, return `true` if `word` exists in the grid. The word can be constructed from letters of sequentially adjacent cells (horizontally or vertically neighboring). The same letter cell may not be used more than once.

**Example:**
- **Input:** `board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"`
- **Output:** `true`
- **Explanation:** The word "ABCCED" can be formed by following a path in the board.

## Approach
The optimal approach uses **backtracking** with depth-first search (DFS) to explore all possible paths starting from each cell. Mark visited cells to avoid reuse and backtrack to explore other paths, achieving O(m*n*3^L) time, where L is the word length.

### Why Backtracking?
- Systematically explores all valid paths.
- Handles the constraint of not reusing cells.

## Pseudocode
```
1. For each cell (i,j) in board:
   a. If board[i][j] == word[0], start DFS from (i,j).
2. DFS function (i, j, index):
   a. If index == word.length, return true (word found).
   b. If (i,j) is out of bounds or board[i][j] != word[index], return false.
   c. Mark cell as visited (e.g., set to '#').
   d. Recurse in four directions (up, down, left, right).
   e. Restore cell and return true if any direction returns true.
3. Return false if no path is found.
```

## Java Solution
```java
/**
 * Solution for the Word Search problem.
 */
public class WordSearch {

    /**
     * Determines if a word exists in the character grid.
     *
     * @param board Grid of characters.
     * @param word  Word to search for.
     * @return True if word exists, false otherwise.
     * @throws IllegalArgumentException If board or word is null.
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word.isEmpty()) {
            return true;
        }

        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '#'; // Mark visited
        boolean found = dfs(board, word, i + 1, j, index + 1) ||
                        dfs(board, word, i - 1, j, index + 1) ||
                        dfs(board, word, i, j + 1, index + 1) ||
                        dfs(board, word, i, j - 1, index + 1);
        board[i][j] = temp; // Restore

        return found;
    }

    public static void main(String[] args) {
        WordSearch solution = new WordSearch();
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println("Word exists: " + solution.exist(board, word)); // true
    }
}
```

## Explanation of the Code
1. **Input Validation**: Checks for null or empty board/word.
2. **DFS Start**: Tries each cell as a starting point if it matches `word[0]`.
3. **DFS Logic**: Checks bounds, matches characters, marks visited cells, and explores four directions.
4. **Backtracking**: Restores cells after exploration.
5. **Edge Cases**: Handles empty words and single-cell boards.

## Time Complexity (TC)
- **O(m*n*3^L)**: Each cell (m*n) can start a DFS, and each DFS explores up to 3 directions (after the first) for word length L.
- Where `m` and `n` are board dimensions, `L` is the word length.

## Space Complexity (SC)
- **O(L)**: Recursion stack depth for word length L.

## Common Interview Questions
1. **What if cells can be reused?**
   - Remove the visited marking, but this changes the problem.
2. **Can we optimize DFS?**
   - Early pruning (e.g., checking remaining length) helps, but complexity remains similar.
3. **What if the word is longer than the board?**
   - Return false early, as implemented.
4. **How do you handle diagonal neighbors?**
   - Modify DFS to include diagonal directions.
5. **What if the board is empty?**
   - Return false unless the word is empty.

## Tips for Interviews
- **Explain DFS Path**: Use a small board to show path exploration.
- **Discuss Marking**: Clarify why cells are marked and restored.
- **Handle Edge Cases**: Mention empty boards and long words.
- **Optimize Discussion**: Suggest pruning or prefix checks.