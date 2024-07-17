package Day02;

public class BestTimetoBuyAndSellStock {
    class Solution {
        public int maxProfit(int[] prices) {
            int min = Integer.MAX_VALUE;
            // int index = 0;
            int maxProfit = 0;
            for(int i=0; i<prices.length; i++)
            {
                // Finding out the minimum price in the array prices.
                min = Math.min(min, prices[i]);
    
                // Then subtracting the minimum price from each price in the array prices
                // and obtainthe maximum difference. The max difference is the maxProfit
                maxProfit = Math.max(maxProfit, prices[i] - min);
            }
            return maxProfit;
        }
    }
}
