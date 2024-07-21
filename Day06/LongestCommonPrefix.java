package Day06;

import java.util.Arrays;

public class LongestCommonPrefix {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            StringBuffer sb = new StringBuffer();
            if (strs == null || strs.length == 0) {
                return sb.toString();
            }
            // Lexicographically sorting the strings
            Arrays.sort(strs);
            String first = strs[0];
            String last = strs[strs.length - 1];

            for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
                if (first.charAt(i) != last.charAt(i)) {
                    return sb.toString();
                } else {
                    sb.append(first.charAt(i));
                }
            }
            return sb.toString();

        }
    }
}
