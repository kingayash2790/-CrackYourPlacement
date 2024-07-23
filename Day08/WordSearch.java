package Day08;

public class WordSearch {
    class Solution {
        // Helper method to perform backtracking
        public boolean backtrack(char[][] board, String word, boolean[][] visited, int i, int j, int ind) {
            // Base case: if all characters in the word are matched
            if (ind == word.length()) {
                // Indicates the complete word has been found
                return true;
            }

            // Check for boundary conditions and if the current cell has already been
            // visited
            // or if the character in the board does not match the current character in the
            // word
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]
                    || board[i][j] != word.charAt(ind)) {
                return false;
            }

            // Mark the current cell as visited
            visited[i][j] = true;

            // Explore all four possible directions: down, up, right, and left
            if (backtrack(board, word, visited, i + 1, j, ind + 1) ||
                    backtrack(board, word, visited, i - 1, j, ind + 1) ||
                    backtrack(board, word, visited, i, j + 1, ind + 1) ||
                    backtrack(board, word, visited, i, j - 1, ind + 1)) {
                return true;
            }

            // Unmark the current cell as visited (backtracking step)
            visited[i][j] = false;
            return false;
        }

        // Main method to check if the word exists in the board
        public boolean exist(char[][] board, String word) {
            int m = board.length; // Number of rows in the board
            int n = board[0].length; // Number of columns in the board
            boolean[][] visited = new boolean[m][n]; // Visited array to keep track of visited cells
            boolean result = false; // Result to check if the word exists in the board

            // Iterate through each cell in the board
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // Start backtracking from the current cell
                    result = backtrack(board, word, visited, i, j, 0);
                    if (result) {
                        // If the word is found, return true
                        return true;
                    }
                }
            }
            // If the word is not found after exploring all cells, return false
            return false;
        }
    }

}
