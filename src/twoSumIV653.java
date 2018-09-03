import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class twoSumIV653 {

    /*
    653. Two Sum IV - Input is a BST
     */

    private class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x){
            val=x;
        }
    }

    /*
    first approach:
    resutrion it will be O(nh)
     */

    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, root,  k);
    }

    public boolean dfs(TreeNode root,  TreeNode cur, int k){
        if(cur == null)return false;
        return search(root, cur, k - cur.val) || dfs(root, cur.left, k) || dfs(root, cur.right, k);
    }

    public boolean search(TreeNode root, TreeNode cur, int value){
        if(root == null)return false;
        return (root.val == value) && (root != cur)
                || (root.val < value) && search(root.right, cur, value)
                || (root.val > value) && search(root.left, cur, value);
    }

    /*
    second approach:
    iterative to get all elements and put into a list them do two sum
    It's a bst, if do inorder traversal, we could get a sorted array
    Although it's O(N), but its slow.
     */
    public boolean findTargetII(TreeNode root, int k) {

        List<Integer> list = new LinkedList<>();
        inorder(root, list);
        int left=0;
        int right=list.size()-1;
        while(left<right){
            int sum=list.get(left)+list.get(right);
            if(sum==k){
                return true;
            }
            else if(sum<k){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, List<Integer> list){
        if(root==null)
            return;
        else {
            if(root.left!=null)
                inorder(root.left, list);
            list.add(root.val);
            if(root.right!=null)
                inorder(root.right,list);
        }
    }

    /*
    third approach to use hashset to solve i
    optimal solution
     */
    public boolean findTargetIII(TreeNode root, int k) {
        if(root==null)
            return false;
        HashSet<Integer> set = new HashSet<>();
        return recursive(root, set, k);
    }

    private boolean recursive(TreeNode root, HashSet<Integer> set,int k){
        if(root==null)
            return false;
        if(set.contains(root.val)){
            return true;
        }else{
            set.add(k-root.val);
        }
        return recursive(root.left, set, k)||recursive(root.right, set, k);
    }



}
