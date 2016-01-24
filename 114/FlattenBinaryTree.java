import java.util.Stack;


class FlattenBinaryTree {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.left.left = new TreeNode(3);
        t.left.right = new TreeNode(4);

        t.right = new TreeNode(5);
        t.right.right = new TreeNode(6);

        Solution s = new Solution();

        printTree(t);
        s.flatten(t);

        printTree(t);

    }
    public static void printTree(TreeNode node) {
        printHelper(node);
        System.out.println();
    }

    public static void printHelper(TreeNode node) {
        if (node == null) return;

        System.out.print("(");
        printHelper(node.left);
        System.out.format("%d", node.val);
        printHelper(node.right);
        System.out.print(")");
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> st = new Stack<TreeNode>();

        if (root.right != null) st.push(root.right);
        if (root.left != null) st.push(root.left);

        TreeNode prev = root;
        TreeNode curr;

        while (!st.empty()) {
            curr = st.pop();

            prev.left = null;
            prev.right = curr;
            prev = curr;

            if (curr.right != null) st.push(curr.right);
            if (curr.left != null) st.push(curr.left);
        }

    }
}
