package Day03;

public class LongestCommonSubstring {
    class Solution {
        int longestCommonSubstr(String S1, String S2, int n, int m) {
            // code here
            int[][] dp = new int[n + 1][m + 1];

            // Initializing the first column with zeroes
            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = 0;
            }
            // Initializing the first row with zeroes
            for (int j = 0; j < dp[0].length; j++) {
                dp[0][j] = 0;
            }

            int ans = 0;
            for (int i = 1; i < dp.length; i++) {

                for (int j = 1; j < dp[0].length; j++) {
                    if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                        // Storing the maximum value in answer
                        ans = Math.max(ans, dp[i][j]);
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
            return ans;
        }
    }
}
