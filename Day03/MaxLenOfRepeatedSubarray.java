package Day03;

public class MaxLenOfRepeatedSubarray {
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;

            int[][] dp = new int[len1 + 1][len2 + 1];

            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = 0;
            }
            for (int j = 0; j < dp[0].length; j++) {
                dp[0][j] = 0;
            }

            int ans = 0;
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
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
