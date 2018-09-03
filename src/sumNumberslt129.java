import java.util.Stack;

public class sumNumberslt129 {

    /*
   129.Sum Root to Leaf Numbers
    Input: [1,2,3]
        1
       / \
      2   3
    Output: 25
    Explanation:
    The root-to-leaf path 1->2 represents the number 12.
    The root-to-leaf path 1->3 represents the number 13.
    Therefore, sum = 12 + 13 = 25.

    Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
     */

    private class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
    recursion approach: if root=null    return 0
                        if root.left==root.right==null return sum*10+root.val
                        else return dfs(left,sum*10+root.val0+ dfs(right,sum*10+root.val)
     */
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        return dfs(root,0);
    }

    private int dfs(TreeNode root, int sum){
        if(root==null) {
            return 0;
        }
        if(root.left==null && root.right==null){
            return sum*10+root.val;
        }
        return dfs(root.left, sum*10+root.val)+dfs(root.right, sum*10+root.val);

    }

    /*
    iterative approach
     */

    public int sumNumbersIterative(TreeNode root) {
        if(root==null)
            return 0;
        int res=0;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.right!=null){
                cur.right.val=cur.val*10+cur.right.val;
                stack.push(cur.right);
            }
            if(cur.left!=null){
                cur.left.val=cur.val*10+cur.left.val;
                stack.push(cur.left);
            }
            if(cur.left==null && cur.right==null){      //leaf
                res+=cur.val;
            }
        }
        return res;
    }

}
