package Day02;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    class Solution {
        public void bfs(int r, int c, int[][] vis, char[][] grid) {
            vis[r][c] = 1;
            int n = grid.length;
            int m = grid[0].length;
            Queue<int[]> queue = new LinkedList<>();
            // Add the starting node to the queue as an array of two integers
            queue.add(new int[] { r, c });
            while (!queue.isEmpty()) {
                int[] position = queue.poll();
                int row = position[0];
                int col = position[1];

                // Directions for moving up, down, left, and right
                int[] delRow = { -1, 1, 0, 0 };
                int[] delCol = { 0, 0, -1, 1 };

                for (int i = 0; i < 4; i++) {
                    int nrow = row + delRow[i];
                    int ncol = col + delCol[i];

                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0
                            && grid[nrow][ncol] == '1') {
                        vis[nrow][ncol] = 1;
                        queue.add(new int[] { nrow, ncol });
                    }
                }
            }
        }

        public int numIslands(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;

            // Initially all the entries of the visited 2D array will be 0 indicating "not
            // visited". If the element of a particular row nd colun is visited , then
            // vis[row][col] = 1
            int[][] vis = new int[n][m];
            int counter = 0;
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < m; col++) {
                    if (vis[row][col] == 0 && grid[row][col] == '1') {
                        counter++;
                        bfs(row, col, vis, grid);
                    }
                }
            }
            return counter;
        }
    }
}
