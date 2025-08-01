# Valid Parentheses

## Problem Statement
Given a string `s` containing only the characters `'('`, `')'`, `'{'`, `'}'`, `'['`, and `']'`, determine if the input string is valid. A string is valid if:
1. Open brackets are closed by the same type of brackets.
2. Open brackets are closed in the correct order.
3. Every close bracket has a corresponding open bracket.

**Example:**
- **Input:** `s = "()"`
- **Output:** `true`
- **Input:** `s = "()[]{}"`
- **Output:** `true`

## Approach
The optimal approach uses a **stack** to track open brackets, matching them with closing brackets in the correct order. This achieves O(n) time and O(n) space.

### Why Stack?
- Ensures correct nesting order (LIFO).
- Efficiently matches opening and closing brackets.

## Pseudocode
```
1. Initialize an empty stack.
2. For each character c in s:
   a. If c is an open bracket, push onto stack.
   b. If c is a close bracket:
      - If stack is empty or top of stack doesn’t match, return false.
      - Pop top of stack.
3. Return true if stack is empty, false otherwise.
```

## Java Solution
```java
import java.util.Stack;

/**
 * Solution for the Valid Parentheses problem.
 */
public class ValidParentheses {

    /**
     * Determines if a string of brackets is valid.
     *
     * @param s Input string of brackets.
     * @return True if valid, false otherwise.
     */
    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (c == ')' && top != '(' || c == '}' && top != '{' || c == ']' && top != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        String s = "()[]{}";
        System.out.println("Valid: " + solution.isValid(s)); // true
    }
}
```

## Explanation of the Code
1. **Input Validation**: Checks for null string.
2. **Stack Usage**: Pushes open brackets, pops to match closing brackets.
3. **Mismatch Check**: Returns false if closing bracket doesn’t match stack top.
4. **Empty Stack**: Ensures all brackets are matched.
5. **Edge Cases**: Handles empty strings and unbalanced brackets.

## Time Complexity (TC)
- **O(n)**: Single pass through the string.
- Where `n` is the length of the input string.

## Space Complexity (SC)
- **O(n)**: Stack may store up to n/2 brackets.

## Common Interview Questions
1. **What if we add other characters?**
   - Ignore non-bracket characters or return false, depending on requirements.
2. **Can we solve without a stack?**
   - Not efficiently for arbitrary nesting depths.
3. **What if the string is empty?**
   - Return true, as it’s valid (no mismatches).
4. **How do you handle very long strings?**
   - The stack approach is efficient, but check for stack overflow.
5. **What if we need to count mismatches?**
   - Modify to track invalid pairs instead of early return.

## Tips for Interviews
- **Explain Stack Logic**: Show how “{[()]}” is processed.
- **Use Examples**: Walk through valid and invalid cases.
- **Discuss Edge Cases**: Mention empty strings and single brackets.
- **Optimize Discussion**: Note hashmap for custom brackets.