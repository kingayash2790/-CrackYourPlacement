package Day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            int n = nums.length; // Length of the input array
            List<List<Integer>> res = new ArrayList<>(); // List to store the result quadruplets

            // Sort the array to make it easier to skip duplicates and use two pointers
            Arrays.sort(nums);

            // Iterate through the array for the first element of the quadruplet
            for (int i = 0; i < n; i++) {
                // Skip duplicate elements for the first position
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                // Iterate through the array for the second element of the quadruplet
                for (int j = i + 1; j < n; j++) {
                    // Skip duplicate elements for the second position
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }

                    // Two pointers for the remaining two elements of the quadruplet
                    int k = j + 1; // Left pointer
                    int l = n - 1; // Right pointer

                    // While the two pointers do not cross each other
                    while (k < l) {
                        // Calculate the sum of the current quadruplet
                        long sum = nums[i];
                        sum += nums[j];
                        sum += nums[k];
                        sum += nums[l];

                        // If the sum matches the target
                        if (sum == target) {
                            // Create a list to store the current quadruplet
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(nums[l]);

                            // Add the current quadruplet to the result list
                            res.add(temp);

                            // Move both pointers to find the next potential match
                            k++;
                            l--;

                            // Skip duplicate elements for the third position
                            while (k < l && nums[k] == nums[k - 1]) {
                                k++;
                            }

                            // Skip duplicate elements for the fourth position
                            while (k < l && nums[l] == nums[l + 1]) {
                                l--;
                            }
                        }
                        // If the sum is less than the target, move the left pointer to the right
                        else if (sum < target) {
                            k++;
                        }
                        // If the sum is greater than the target, move the right pointer to the left
                        else {
                            l--;
                        }
                    }
                }
            }

            // Return the list of all quadruplets that sum up to the target
            return res;
        }
    }

}
