package Day07;

import java.util.Arrays;
import java.util.Stack;

public class SimplifyPath {
    class Solution {
        public String simplifyPath(String path) {
            String[] tokens = path.split("/+");
            Stack<String> stack = new Stack<String>();
            for (String t : tokens) {
                if (stack.size() > 0 && t.equals("..")) {
                    stack.pop();
                } else if (!Arrays.asList("", ".", "..").contains(t)) {
                    stack.push(t);
                }
            }
            StringBuilder sb = new StringBuilder();
            // this will iterate from the element inserted first t the element inserted last
            for (String s : stack) {
                sb.append("/").append(s);
            }
            return sb.length() == 0 ? "/" : sb.toString();

            // return "/" + String.join("/", stack);
        }
    }
}
