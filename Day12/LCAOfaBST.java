package Day12;

public class LCAOfaBST {
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
            if (root == null) {
                return null;
            }

            int rootVal = root.val;

            if (rootVal < p.val && rootVal < q.val) {
                // TreeNode p and q lie on the right half of the BST
                return lowestCommonAncestor(root.right, p, q);
            }
            if (p.val < rootVal && q.val < rootVal) {
                // TreeNode p and q lie on the right half of the BST
                return lowestCommonAncestor(root.left, p, q);
            }
            return root;
        }
    }
}
