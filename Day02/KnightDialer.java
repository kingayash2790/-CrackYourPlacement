package Day02;

public class KnightDialer {
    class Solution {
        // Define the modulus value for large numbers to avoid overflow.
        int mod = 1000000007;
        
        // Define the possible moves for the knight on a keypad, where the index corresponds
        // to the current key and the array elements are the keys the knight can move to.
        int[][] arr = { 
            { 4, 6 },    // From key 0, the knight can move to keys 4 and 6.
            { 6, 8 },    // From key 1, the knight can move to keys 6 and 8.
            { 7, 9 },    // From key 2, the knight can move to keys 7 and 9.
            { 4, 8 },    // From key 3, the knight can move to keys 4 and 8.
            { 0, 3, 9 }, // From key 4, the knight can move to keys 0, 3, and 9.
            {},          // From key 5, the knight cannot move to any key.
            { 0, 1, 7 }, // From key 6, the knight can move to keys 0, 1, and 7.
            { 2, 6 },    // From key 7, the knight can move to keys 2 and 6.
            { 1, 3 },    // From key 8, the knight can move to keys 1 and 3.
            { 2, 4 }     // From key 9, the knight can move to keys 2 and 4.
        };
    
        // The solver function recursively calculates the number of distinct numbers of length `n`
        // starting from key `i`. It uses memoization to store the results of subproblems.
        public int solver(int n, int i, int[][] dp) {
            // Base case: If no more moves are needed (n == 0), return 1 as a valid number is formed.
            if (n == 0) {
                return 1;
            }
            
            // If the result for this subproblem is already calculated, return it.
            if (dp[n][i] != -1) {
                return dp[n][i];
            }
            
            // Initialize the answer for the current subproblem.
            int ans = 0;
            
            // Loop through all possible moves from the current key `i`.
            for (int it : arr[i]) {
                // Recursively solve for the next move and add the result to `ans`.
                ans = (ans + solver(n - 1, it, dp)) % mod;
            }
            
            // Store the result in the dp array and return it.
            return dp[n][i] = ans;
        }
    
        // The knightDialer function initializes the dp array and calculates the total number
        // of distinct numbers the knight can di    al of length `n`.
        public int knightDialer(int n) {
            // Initialize the result variable to store the final count of distinct numbers.
            int result = 0;
            
            // Create a dp array to store results of subproblems.
            // n -> size of the number to be dialed
            // 10 -> is the number of options available for each digit of the number of size n
            int[][] dp = new int[n][10];
            
            // Initialize the dp array with -1 indicating uncomputed results.
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 10; j++) {
                    dp[i][j] = -1;
                }
            }
            
            // Calculate the total number of distinct numbers starting from each key (0 to 9).
            for (int cell = 0; cell <= 9; cell++) {
                result = (result + solver(n - 1, cell, dp)) % mod;
            }
            
            // Return the final result.
            return result;
        }
    }
    
}
