package Day12;

public class LCAOfABinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }

            // DFS traversal
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            // result
            if (left == null) {
                return right;
            } else if (right == null) {
                return left;
            } else {
                // If both the left and right are null, then return the root
                return root;
            }
        }
    }
}
