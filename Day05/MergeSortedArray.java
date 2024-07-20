package Day05;

import java.util.Arrays;

public class MergeSortedArray {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // i is to keep track of indices in nums1 where elements of nums2 will be stored
            // j is to keep track of elements in nums2
            for (int j = 0, i = m; j < n; j++) {
                nums1[i] = nums2[j];
                i++;
            }
            Arrays.sort(nums1);
        }
    }
}
