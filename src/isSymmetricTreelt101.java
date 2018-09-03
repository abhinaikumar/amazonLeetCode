import java.util.LinkedList;
import java.util.Queue;

public class isSymmetricTreelt101 {

    /*
    101. Symmetric Tree
    Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

    For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

        1
       / \
      2   2
     / \ / \
    3  4 4  3

    But the following [1,2,2,null,3,null,3] is not:
        1
       / \
      2   2
       \   \
       3    3
     */

    private class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x){
            val=x;
        }
    }

    /*
    first approach: iterative

    root.left.left=root.right.right
    root.left.right=root.right.left
    ...
    push and pop two nodes at one time

     */

    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        Queue<TreeNode> queue=new LinkedList<>();
        if(root.left!=null&&root.right!=null){
            queue.add(root.left);
            queue.add(root.right);
        }
        else if(root.left==null&&root.right==null){
            return true;
        }else{
            return false;
        }
        while(!queue.isEmpty()){
            int size=queue.size();  //size is each level's node number
            while(size>0){
                TreeNode left = queue.poll();
                TreeNode right = queue.poll();
                if(left.val!=right.val) {
                    return false;
                }
                if(left.left!=null &&right.right!=null ){
                    queue.add(left.left);
                    queue.add(right.right);
                }else{
                    if(left.left!=null || right.right!=null){
                        return false;
                    }
                }
                if(left.right!=null && right.left!=null){
                    queue.add(left.right);
                    queue.add(right.left);
                }else{
                    if(left.right!=null || right.left!=null){
                        return false;
                    }
                }
                size-=2;
            }
        }
        return true;
    }


    /*
    second approach: recursion
     */
    public boolean isSymmetricRecursion(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right){
       if(left!=null || right!=null){       //combine two cases into one if statement, so clever!
           return left==right;
       }
       if(left.val!=right.val){
           return false;
       }
       return isSymmetricHelper(left.left,right.right)&&isSymmetricHelper(left.right, right.left);
    }
}
