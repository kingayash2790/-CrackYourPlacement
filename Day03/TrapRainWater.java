package Day03;

public class TrapRainWater {
    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            // Creating left and right arrays of same length as of height array
            int[] left = new int[n];
            int[] right = new int[n];

            // Filling the left array
            left[0] = height[0];
            for (int i = 1; i < n; i++) {
                left[i] = Math.max(height[i], left[i - 1]);
            }

            // Filling the right array
            right[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                right[i] = Math.max(height[i], right[i + 1]);
            }

            // Calculating the amount of water stored
            int waterStored = 0;
            for (int i = 0; i < n; i++) {
                // Calculating the minimum height out of two maximum heights from left and right
                // arrays
                int minHeight = Math.min(left[i], right[i]);
                waterStored += minHeight - height[i];
            }
            return waterStored;
        }
    }
}
