import java.util.*;

public class inOrderTravesalBST {

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    /*
    iterative by stack
     */
    public List<Integer> inOrderTravelsalBST(TreeNode root){
        List<Integer> list=new ArrayList<>();
        if(root==null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            list.add(root.val);
            root=root.right;
        }
        return list;
    }

    /*
    recursive
     */
    public List<Integer> inOrderTravelsalBST1(TreeNode root){
        List<Integer> list=new LinkedList<>();
        helper(root,list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list){
        if(root!=null){
            if(root.left!=null)
                helper(root.left, list);
            list.add(root.val);
            if(root.right!=null){
                helper(root.right, list);
            }
        }
    }
}
