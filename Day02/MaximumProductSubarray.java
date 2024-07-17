package Day02;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int n = nums.length; // Get the length of the array.
        double prefix = 1;   // Initialize the prefix product to 1.
        double suffix = 1;   // Initialize the suffix product to 1.
        double max = Integer.MIN_VALUE; // Initialize the max product to the smallest possible integer value.

        // Loop through the array to calculate the prefix and suffix products.
        for (int i = 0; i < n; i++) {
            // If the prefix product becomes zero, reset it to 1 (start a new subarray).
            if (prefix == 0) {
                prefix = 1;
            }
            // If the suffix product becomes zero, reset it to 1 (start a new subarray).
            if (suffix == 0) {
                suffix = 1;
            }
            // Update the prefix product by multiplying with the current element.
            prefix = prefix * nums[i];
            // Update the suffix product by multiplying with the element from the end.
            suffix = suffix * nums[n - i - 1];

            // Update the max product with the maximum of the current max, prefix, and suffix products.
            max = Math.max(max, Math.max(prefix, suffix));
        }
        
        // Return the maximum product as an integer.
        return (int) max;
    }
}
