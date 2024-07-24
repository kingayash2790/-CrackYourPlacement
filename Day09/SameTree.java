package Day09;

public class SameTree {

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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            // Here p and q are the root nodes of their respective trees
            // Initially if both p and q are null, that means both the trees are empty,
            // hence they are same
            if (p == null && q == null) {
                return true;
            }

            // If any one of the root is not null, or if the values are not matching, then
            // the trees are not same, hence return false;
            if (p == null || q == null || p.val != q.val) {
                return false;
            }

            // Repeat the same for left and right children of both p and q
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
