package Day09;

import java.util.Stack;

import javax.swing.tree.TreeNode;

public class BSTIterator {

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

    class BSTiterator {

        Stack<TreeNode> stack = new Stack<>();

        public BSTiterator(TreeNode root) {
            pushAll(root);
        }

        public int next() {
            TreeNode temp = stack.pop();
            pushAll(temp.right);
            return temp.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public void pushAll(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }

    private Object root;

    BSTIterator obj = new BSTIterator();
    int param_1 = obj.next();
    int param_2 = obj.next();
    private int next() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'next'");
    }

}
