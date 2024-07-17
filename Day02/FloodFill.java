package Day02;

public class FloodFill {
    class Solution {
        // Helper method to perform Depth-First Search (DFS) for flood fill
       public void dfs(int[][] image, int row, int col, int initColor, int newColor, int[][] ans, int[] delrow, int[] delcol) {
           // Change the color of the current pixel to the new color
           image[row][col] = newColor;
           int n = image.length; // Number of rows in the image
           int m = image[0].length; // Number of columns in the image
   
           // Explore all four possible directions (up, right, down, left)
           for (int i = 0; i < 4; i++) {
               int nrow = row + delrow[i]; // Calculate new row index
               int ncol = col + delcol[i]; // Calculate new column index
   
               // Check if the new position is within bounds and has the initial color,
               // and if it has not been already colored with the new color
               if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == initColor && ans[nrow][ncol] != newColor) {
                   // Perform DFS on the new position
                   dfs(image, nrow, ncol, initColor, newColor, ans, delrow, delcol);
               }
           }
       }
   
       // Main method to perform flood fill
       public int[][] floodFill(int[][] image, int sr, int sc, int color) {
           int initColor = image[sr][sc]; // Get the initial color of the starting pixel
           int[] delrow = {-1, 0, +1, 0}; // Row deltas for moving up, right, down, left
           int[] delcol = {0, +1, 0, -1}; // Column deltas for moving up, right, down, left
   
           int[][] ans = image; // Resulting image after flood fill
   
           // Perform DFS starting from the initial pixel
           dfs(image, sr, sc, initColor, color, ans, delrow, delcol);
           return ans; // Return the modified image
       }
   }
}
