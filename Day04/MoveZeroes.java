package Day04;

import java.util.ArrayList;

public class MoveZeroes {

    class Solution {
        public void moveZeroes(int[] nums) {
            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                // Adding zeroes in a list2
                if (nums[i] == 0) {
                    list2.add(nums[i]);
                }

                // Adding non-zeroes elements in a list1
                else {
                    list1.add(nums[i]);
                }
            }

            // Joining both the lists and storing it in list1
            list1.addAll(list2);

            // int [] res = new int[nums.length];
            for (int i = 0; i < list1.size(); i++) {
                nums[i] = list1.get(i);
            }
            System.out.println(nums);
        }
    }
}
