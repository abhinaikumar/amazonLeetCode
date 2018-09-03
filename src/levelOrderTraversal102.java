import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrderTraversal102 {
    /*
    102. Binary Tree Level Order Traversal
    Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
    For example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7

   return its level order traversal as:
    [
      [3],
      [9,20],
      [15,7]
    ]

     */

    private class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int x){
            val=x;
        }
    }

    /*
    first approach: recursion

     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res=new LinkedList<>();
        if(root==null){
            return res;
        }
        traversal(root, 0, res);
        return res;
    }

    private void traversal(TreeNode root, int level, List<List<Integer>> res){
        if(root==null)
            return;
        if(res.size()==level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        traversal(root.left,level+1, res);
        traversal(root.right,level+1, res);

    }

    /*
    iterative approach
     */
    public List<List<Integer>> levelOrderII(TreeNode root) {

        List<List<Integer>> res=new LinkedList<>();
        if(root==null)
            return res;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int level=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list =  new LinkedList<>();
            while(size>0){
                TreeNode node=queue.poll();
                list.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                size--;
            }
            res.add(level, list);
            level++;
        }
        return res;
    }
}
