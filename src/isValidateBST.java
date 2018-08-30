import java.util.Stack;

public class isValidateBST {
    /*
    98. Validate Binary Search Tree
    Given a binary tree, determine if it is a valid binary search tree (BST).

    Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

    Input:
        2
       / \
      1   3
    Output: true

        5
       / \
      1   4
         / \
        3   6
    Output: false
    Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
                 is 5 but its right child's value is 4.
     */
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    /*
    recursive solution
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minVal, long maxVal){
        if(root==null)
            return true;
        if(root.val<=minVal||root.val>=maxVal)
            return false;
        return isValidBST(root.left, minVal, root.val)&&isValidBST(root.right, root.val, maxVal);
    }

    /*
    iterative method use inorder traversal
     */

    public boolean isValidBST2(TreeNode root){
        if(root==null)
            return true;
        TreeNode prev=null;
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root= stack.pop();
            if(prev!=null && root.val<=prev.val)
                return false;
            prev=root;
            root=root.right;
        }
        return true;
    }

}
