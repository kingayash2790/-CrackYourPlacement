package Day04;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);

            Set<List<Integer>> set = new HashSet<>();
            List<List<Integer>> result = new ArrayList<>();

            for (int i = 0; i < nums.length - 1; i++) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                    } else if (nums[i] + nums[j] + nums[k] < 0) {
                        j++;

                    } else {
                        k--;
                    }
                }
            }
            result.addAll(set);
            return result;
        }
    }
}
