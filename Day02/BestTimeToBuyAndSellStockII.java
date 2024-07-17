package Day02;

public class BestTimeToBuyAndSellStockII {
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length; // Get the length of the prices array
            int result = 0; // Initialize the variable to store the total profit
    
            // Iterate through the prices array starting from the second element
            for (int i = 1; i < n; i++) {
                int profit = 0; // Initialize the profit for the current transaction to 0
                int sell = prices[i]; // Get the selling price (current day's price)
                int buy = prices[i - 1]; // Get the buying price (previous day's price)
    
                // Calculate the profit for the current transaction
                profit = sell - buy;
    
                // If the calculated profit is positive, add it to the result
                if (profit > 0) {
                    result += profit;
                }
            }
    
            // Return the total profit after processing all transactions
            return result;
        }
    }
}
