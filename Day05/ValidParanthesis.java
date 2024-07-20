package Day05;

import java.util.Stack;

public class ValidParanthesis {
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<Character>();

            // if(stack.isEmpty())
            // {
            // return false;
            // }
            // Iterate through each character in the string
            for (char c : s.toCharArray()) {
                // If the character is an opening bracket, push it onto the stack
                if ((c == '(') || (c == '[') || (c == '{')) {
                    stack.push(c);
                } else { // If the character is a closing bracket
                    // If the stack is empty, there's no corresponding opening bracket, so the
                    // string is invalid
                    if (stack.isEmpty()) {
                        return false;
                    }
                    // Retrieve the top element of the stack
                    char top = stack.peek();
                    // If the current character matches the corresponding opening bracket, pop the
                    // top element
                    if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{')) {
                        stack.pop();
                    } else { // If the current character does not match the corresponding opening bracket,
                             // the string is invalid
                        return false;
                    }
                }
            }
            // After iterating through the entire string, if the stack is empty, all
            // brackets are matched
            return stack.isEmpty();
        }
    }
}
