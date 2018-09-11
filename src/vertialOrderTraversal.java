import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class vertialOrderTraversal {
    /*
    314. Binary Tree Vertical Order Traversal
    Input: [3,9,20,null,null,15,7]

       3
      /\
     /  \
     9  20
        /\
       /  \
      15   7

    Output:

    [
      [9],
      [3,15],
      [20],
      [7]
    ]
     */

    private class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int x){
            val=x;
        }
    }

    private class Pair{
        int val;
        TreeNode node;
        Pair(TreeNode node, int x){
            this.node=node;
            this.val=x;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> res=new LinkedList<>();
        List<List<Pair>> t=new LinkedList<>();
        if(root==null)
            return res;

        List<Pair> list = new ArrayList<>();
        bfs(root,list,0,t,0);
        int left=Integer.MAX_VALUE;
        int right=Integer.MIN_VALUE;
        for(Pair p:list){
            if(p.val<left){
                left=p.val;
            }
            if(p.val>right){
                right=p.val;
            }
        }
        int total=Math.abs(left)+right+1;
        for(int i=0; i<total; i++){
            res.add(i, new ArrayList<>());
        }
        int shift=Math.abs(left);
        for(int i=t.size()-1;i>=0; i--){
            List<Pair> l=t.get(i);
            for(Pair p:l){
                res.get(p.val+shift).add(p.node.val);
            }
        }
        return res;
    }

    private void bfs(TreeNode root, List<Pair> list, int hposition,List<List<Pair>> t, int level){
        if(root==null)
            return;
        if(t.size()==level){
            t.add(new ArrayList<>());
        }
        list.add(new Pair(root, hposition));
        t.get(level).add(new Pair(root, hposition));
        bfs(root.left,list,hposition-1, t, level+1);
        bfs(root.right,list,hposition-1, t, level+1);
    }
}
