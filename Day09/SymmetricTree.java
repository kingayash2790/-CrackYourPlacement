package Day09;

public class SymmetricTree {

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
        public boolean isMirror(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }

            // if any one out of left and right is null, then it return false (not
            // symmetric)
            if (left == null || right == null) {
                return false;
            }
            boolean res = left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
            return res;
        }

        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isMirror(root.left, root.right);
        }
    }
}
