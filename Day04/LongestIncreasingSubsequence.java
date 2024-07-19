package Day04;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    class Solution {
        public int LIS(int ind, int prev_index, int[] nums, int n, int[][] dp) {
            // Base Case - If you run out of elements in the array i.e., you reached the end
            // of the array
            if (ind == n) {
                return 0;
            }

            if (dp[ind][prev_index + 1] != -1) {
                return dp[ind][prev_index + 1];
            }

            // notPick
            int notPick = 0 + LIS(ind + 1, prev_index, nums, n, dp);

            // Pick
            int pick = 0;
            if (prev_index == -1 || nums[prev_index] < nums[ind]) {
                pick = 1 + LIS(ind + 1, ind, nums, n, dp);
            }
            return dp[ind][prev_index + 1] = Math.max(pick, notPick);
        }

        public int lengthOfLIS(int[] nums) {
            int n = nums.length;

            // two parameters operating are: ind, prev_ind
            // ind -> range from 0 to n-1, hence the size can be n
            // prev_ind -> ranges from -2 to n-2, hence size will be n+1
            int[][] dp = new int[n][n + 1];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }
            return LIS(0, -1, nums, n, dp);
        }
    }
}
