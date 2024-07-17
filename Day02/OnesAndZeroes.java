package Day02;

public class OnesAndZeroes {
    class Solution {
        // Helper function to recursively solve the problem with memoization
        public int helper(int ind, int m, int n, String[] strs, int[][][] dp) {
            // Base Case
            // If the index 'ind' has reached the end of the array or if both 'm' and 'n' are zero
            if (ind == strs.length || (m + n == 0)) {
                return 0;
            }
    
            // If the solution value for this subproblem is already in the dp array, use it
            if (dp[m][n][ind] > 0) {
                return dp[m][n][ind];
            }
    
            // Count the number of 0s and 1s in the current string
            int[] count = count(strs[ind]);
    
            // Option 1: Pick the current string if it fits within the remaining m 0s and n 1s
            int pick = 0;
            if (count[0] <= m && count[1] <= n) {
                pick = 1 + helper(ind + 1, m - count[0], n - count[1], strs, dp);
            }
    
            // Option 2: Do not pick the current string
            int notPick = helper(ind + 1, m, n, strs, dp);
    
            // Store the maximum of picking and not picking the current string in the dp array
            return dp[m][n][ind] = Math.max(pick, notPick);
        }
    
        // Function to count the number of 0s and 1s in a given string
        public int[] count(String s) {
            int[] count = new int[2];
            for (char c : s.toCharArray()) {
                count[c - '0']++;
            }
            return count;
        }
    
        // Main function to find the maximum number of strings that can be formed
        public int findMaxForm(String[] strs, int m, int n) {
            int len = strs.length;
    
            // Create a 3D dp array where dp[m][n][ind] represents the maximum number of strings
            // that can be formed with 'm' 0s, 'n' 1s, starting from index 'ind'
            int[][][] dp = new int[m+1][n+1][len];
    
            // Call the helper function starting from index 0
            return helper(0, m, n, strs, dp);
        }
    }
    
}
