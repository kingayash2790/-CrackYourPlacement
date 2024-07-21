package Day06;

import java.util.HashMap;

public class TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();

            // Building the hashmap by storing all the array elements in the hashmap
            // Key: element; Value: its index
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }

            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement) && map.get(complement) != i) {
                    return new int[] { i, map.get(complement) };
                }
            }

            // No solution
            return new int[] {};
        }
    }
}
