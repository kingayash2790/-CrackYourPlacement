package Day09;

public class MaxPointsObtainedFromCards {
    class Solution {
        public int maxScore(int[] cardPoints, int k) {
            int n = cardPoints.length;
            int lsum = 0, rsum = 0, maxSum = 0;

            // Calculate the initial sum of the first 'k' cards from the left side
            for (int i = 0; i < k; i++) {
                lsum += cardPoints[i];
            }

            // Initialize maxSum with the initial left sum
            maxSum = lsum;

            // Initialize the right index which will be used to pick cards from the right
            // side
            int rIndex = n - 1;

            // Iterate through the cards from the right side to left side
            for (int i = k - 1; i >= 0; i--) {
                // Remove the i-th card from the left sum
                lsum -= cardPoints[i];

                // Add the card from the right side to the right sum
                rsum += cardPoints[rIndex];

                // Move the right index to the left
                rIndex--;

                // Update maxSum with the maximum of the current maxSum and the sum of the
                // current left sum and right sum
                maxSum = Math.max(maxSum, lsum + rsum);
            }

            // Return the maximum score possible by picking 'k' cards
            return maxSum;
        }
    }

}
