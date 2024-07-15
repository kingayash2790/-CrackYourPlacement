// Jump Game

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length; // Get the length of the array
        int reachable = 0;   // Initialize the farthest index that can be reached to 0
        
        for (int i = 0; i < n; i++) { // Iterate through each index of the array
            if (i > reachable) {      // If the current index is greater than the farthest reachable index
                return false;         // It means we can't reach this index, so return false
            }
            reachable = Math.max(reachable, i + nums[i]); // Update the farthest reachable index
        }
        return true; // If we complete the loop, it means we can reach the last index, so return true
    }
}
