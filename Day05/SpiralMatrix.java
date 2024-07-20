package Day05;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();

            if (matrix.length == 0) {
                return result;
            }

            int top = 0, bottom = matrix.length - 1;
            int left = 0, right = matrix[0].length - 1;

            while (top <= bottom && left <= right) {
                // Loop 1: to traverse the 1st row
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                top++;

                // Loop 2: to traverse the last column from the latest value of top to last row
                for (int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                }
                right--;

                // Loop 3: to traverse the last row from right to left from the latest value of
                // right
                if (top <= bottom) {
                    for (int i = right; i >= left; i--) {
                        result.add(matrix[bottom][i]);
                    }
                    bottom--;
                }

                // Loop 4: to traverse the 1st column from bottom to top
                if (left <= right) {
                    for (int i = bottom; i >= top; i--) {
                        result.add(matrix[i][left]);
                    }
                    left++;
                }
            }
            return result;
        }
    }
}
