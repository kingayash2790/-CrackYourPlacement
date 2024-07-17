// Climbing Stairs

package Day02;

class Solution {
    int[] dp; // Declare an array to store the results of subproblems.

    public int climbStairs(int n) {
        // Base Case: If there are 0 or 1 steps, there is only 1 way to climb.
        if (n == 0 || n == 1) {
            return 1;
        }

        // Initialize the dp array with size n + 1.
        dp = new int[n + 1];
        
        // Base Case Initialization: There is 1 way to climb 0 or 1 step.
        dp[0] = 1;
        dp[1] = 1;

        // Fill the dp array for all steps from 2 to n.
        for (int i = 2; i <= n; i++) {
            // The number of ways to climb i steps is the sum of the ways to climb (i-1) steps and (i-2) steps.
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Return the number of ways to climb n steps.
        return dp[n];
    }
}

