package Day03;

import java.util.Arrays;

public class CoinChange {
    class Solution {
        public int f(int ind, int[] coins, int amount, int[][] dp) {
            if (ind == 0) {
                if (amount % coins[0] == 0) {
                    return amount / coins[0];
                } else {
                    return 100000;
                }
            }

            if (dp[ind][amount] != -1) {
                return dp[ind][amount];
            }
            int notTake = 0 + f(ind - 1, coins, amount, dp);
            int Take = 100000;
            if (coins[ind] <= amount) {
                Take = 1 + f(ind, coins, amount - coins[ind], dp);
            }
            return dp[ind][amount] = Math.min(Take, notTake);
        }

        public int coinChange(int[] coins, int amount) {
            int n = coins.length;
            int[][] dp = new int[n + 1][amount + 1];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(dp[i], -1);
            }

            int ans = f(n - 1, coins, amount, dp);
            if (ans >= 100000) {
                return -1;
            }
            return ans;
        }
    }
}
