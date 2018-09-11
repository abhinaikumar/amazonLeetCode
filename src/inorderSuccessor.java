import java.util.LinkedList;
import java.util.List;

public class inorderSuccessor {

    /*
    285. Inorder Successor in BST
    Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

    Note: If the given node has no in-order successor in the tree, return null.

    Example 1:

    Input: root = [2,1,3], p = 1

      2
     / \
    1   3

    Output: 2


    Example 2:

    Input: root = [5,3,6,2,4,null,null,1], p = 6

          5
         / \
        3   6
       / \
      2   4
     /
    1

    Output: null
     */

    private class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x){
            val=x;
        }
    }


    public TreeNode successor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val <= p.val) {
            return successor(root.right, p);
        } else {
            TreeNode left = successor(root.left, p);
            return (left != null) ? left : root;
        }
    }

}
