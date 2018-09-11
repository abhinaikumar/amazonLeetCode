import java.util.LinkedList;
import java.util.List;

public class increasingBST {

    /*
    897. Increasing Order Search Tree
    Given a tree, rearrange the tree in in-order so that the leftmost node in
    the tree is now the root of the tree, and every node has no left child and only 1 right child.

    Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9
     */

    /*
    approach when I wrote in the contest
     */
    private class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int x){
            val=x;
        }
    }

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list=new LinkedList<>();
        inorder(root,list);
        TreeNode head=new TreeNode(list.get(0));
        TreeNode dummy=new TreeNode(0);
        dummy.right=head;
        for(int i=1; i<list.size();i++){
            head.right=new TreeNode(list.get(i));
            head=head.right;
        }
        return dummy.right;
    }

    private void inorder(TreeNode root, List<Integer> list){
        if(root==null){
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }

    /*
    discussion solution:

    I didn't use this condition of BST, and just inorder output the whole tree.

    Straigh forward idea:
    res = inorder(root.left) + root + inorder(root.right)

    Several tips here:

    I pass a tail part to the function, so it can link it to the last node.
    This operation takes O(1), instead of O(N).
    Otherwise the whole time complexity will be O(N^2).

    Also, remember to set root.left = null.
    Otherwise it will be TLE for Leetcode to traverse your tree.

    Should arrange the old tree, not create a new tree.
    The judgement won't take it as wrong answer, but it is.
     */

    public TreeNode increasingBSTII(TreeNode root) {
        return helper(root, null);
    }

    public TreeNode helper(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode res = helper(root.left, root);
        root.left = null;
        root.right = helper(root.right, tail);
        return res;
    }
}
