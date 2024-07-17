package Day02;

public class SortColors {
    class Solution {
        public void sortColors(int[] nums) {

            // to store the frequencies of 0s, 1s and 2s
            int[] freq = new int[] { 0, 0, 0 };

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    freq[0]++;
                } else if (nums[i] == 1) {
                    freq[1]++;
                } else {
                    freq[2]++;
                }
            }

            // iter is the types of colors i.e., 0, 1 or 2
            int iter = 0;
            for (int i = 0; i < nums.length;) {
                if (freq[iter] > 0) {
                    nums[i] = iter;
                    freq[iter]--;
                    i++;
                } else {
                    // Move to the next color
                    iter++;
                }
            }
        }
    }
}
