package Day12;

import java.util.ArrayList;
import java.util.List;

public class RightSideViewOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        // Function to return the list of values visible from the right side view of a
        // binary tree.
        public List<Integer> rightSideView(TreeNode root) {
            // Initialize the result list to store the right side view nodes.
            List<Integer> res = new ArrayList<>();
            // Call the helper function to populate the right side view nodes.
            rightView(root, res, 0);
            // Return the result list.
            return res;
        }

        // Helper function to perform a depth-first search to find the right side view
        // nodes.
        public void rightView(TreeNode node, List<Integer> res, int level) {
            // Base case: If the current node is null, return.
            if (node == null) {
                return;
            }

            // If the current level is equal to the size of the result list, it means we are
            // visiting this level for the first time.
            // Therefore, we add the current node's value to the result list.
            if (level == res.size()) {
                res.add(node.val);
            }

            // Recursively call the function for the right subtree first to ensure rightmost
            // nodes are processed first.
            rightView(node.right, res, level + 1);
            // Recursively call the function for the left subtree.
            rightView(node.left, res, level + 1);
        }
    }
}
