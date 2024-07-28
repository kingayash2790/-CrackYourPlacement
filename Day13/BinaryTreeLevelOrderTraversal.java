package Day13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            // Initialize a queue to help with the level order traversal
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            // Initialize a list to store the final result
            List<List<Integer>> wrapList = new ArrayList<>();

            // If the root is null, just return the empty wrapList
            if (root == null) {
                return wrapList;
            }

            // Add the root to the queue to start the traversal
            queue.offer(root);

            // Continue the traversal while there are nodes in the queue
            while (!queue.isEmpty()) {
                // Get the number of nodes at the current level
                int size = queue.size();
                // Initialize a sublist to store values of nodes at the current level
                List<Integer> subList = new ArrayList<>();

                // Process each node at the current level
                for (int i = 0; i < size; i++) {
                    // Check the left child of the current node, if it exists, add it to the queue
                    if (queue.peek().left != null) {
                        queue.offer(queue.peek().left);
                    }
                    // Check the right child of the current node, if it exists, add it to the queue
                    if (queue.peek().right != null) {
                        queue.offer(queue.peek().right);
                    }
                    // Add the value of the current node to the sublist and remove it from the queue
                    subList.add(queue.poll().val);
                }
                // Add the sublist to the wrapList
                wrapList.add(subList);
            }
            // Return the final result containing all levels
            return wrapList;
        }
    }
}