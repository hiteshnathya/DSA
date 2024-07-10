package Assignment.Day5;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public static void main(String[] args) {
        BalancedBinaryTree bbTree = new BalancedBinaryTree();

        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Is the tree balanced? " + bbTree.isBalanced(root));
    }
}