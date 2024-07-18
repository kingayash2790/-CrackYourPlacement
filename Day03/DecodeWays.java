package Day03;

import java.util.Arrays;

public class DecodeWays {
    class Solution {
        public int decode(int ind, String s, int[] dp, int n) {
            if (ind == n) {
                return dp[ind] = 1; // one split is done
            }

            if (dp[ind] != -1) {
                return dp[ind];
            }

            if (s.charAt(ind) == '0') {
                return dp[ind] = 0;
            }

            int result = decode(ind + 1, s, dp, n);

            if (ind + 1 < n) {
                if ((s.charAt(ind) == '1') || (s.charAt(ind) == '2' && s.charAt(ind + 1) <= '6')) {
                    result += decode(ind + 2, s, dp, n);
                }
            }
            return dp[ind] = result;
        }

        public int numDecodings(String s) {
            int n = s.length();
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            return dp[n] = decode(0, s, dp, n);
        }
    }
}
