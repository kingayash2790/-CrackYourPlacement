package Day06;

public class RotateImage {
    class Solution {

        // Step 1: find the transpose of the matrix
        void transpose(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i; j < matrix[0].length; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

        // Step 2: reverse the rows of the transposed matrix
        void reverseRows(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                // use of two pointers: left and right
                int left = 0;
                int right = matrix.length - 1;

                while (left < right) {
                    int temp = matrix[i][left];
                    matrix[i][left] = matrix[i][right];
                    matrix[i][right] = temp;

                    left++;
                    right--;
                }
            }
        }

        public void rotate(int[][] matrix) {
            transpose(matrix);
            reverseRows(matrix);
        }
    }
}
