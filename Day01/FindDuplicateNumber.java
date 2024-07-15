// Find the Duplicate Number

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++)
        {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        int res = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet())
        {
            int key = entry.getKey();
            int value = entry.getValue();

            if(value > 1)
            {
                res = key;
            } 
        }
        return res;
    }
}