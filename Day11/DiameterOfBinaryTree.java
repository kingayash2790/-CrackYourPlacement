package Day11;

public class DiameterOfBinaryTree {
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
        public int height(TreeNode node, int[] diameter) {
            if (node == null) {
                return 0;
            }
            // Calculating the left height
            int leftHeight = height(node.left, diameter);

            // Calculating the right height
            int rightHeight = height(node.right, diameter);

            // Calculating the maximum of sum of leftHeight and rightSum
            diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
            return 1 + Math.max(leftHeight, rightHeight);

        }

        public int diameterOfBinaryTree(TreeNode root) {
            int[] diameter = new int[1];
            height(root, diameter);
            return diameter[0];
        }
    }
}
