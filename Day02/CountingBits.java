package Day02;

public class CountingBits {
    class Solution {
        public int[] countBits(int n) {
            // Initialize an array 'ans' of size 'n + 1' to store the number of 1's in the binary representation
            // of each number from 0 to n. The array is initially filled with zeros.
            int[] ans = new int[n + 1];
            
            // Loop through each number from 1 to n to calculate the number of 1's in its binary representation
            for (int i = 1; i <= n; i++) {
                // The number of 1's in the binary representation of 'i' can be derived from the number of 1's in 'i / 2'
                // (which is the same as 'i >> 1') plus 1 if 'i' is odd (i.e., the least significant bit is 1).
                // 'i >> 1' is equivalent to 'i / 2', shifting the bits of 'i' to the right by 1.
                // 'i & 1' checks if the least significant bit of 'i' is 1 (i.e., if 'i' is odd).
                ans[i] = ans[i >> 1] + (i & 1);
            }
            
            // Return the resulting array, which contains the number of 1's for each number from 0 to n.
            return ans;
        }
    }
    
}
