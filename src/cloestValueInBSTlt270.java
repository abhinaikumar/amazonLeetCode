public class cloestValueInBSTlt270 {
    /*
    270. Closest Binary Search Tree Value
    Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

    Note:

    Given target value is a floating point.
    You are guaranteed to have only one unique value in the BST that is closest to the target.

    Input: root = [4,2,5,1,3], target = 3.714286

        4
       / \
      2   5
     / \
    1   3

    Output: 4

     */

    private class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int closestValue(TreeNode root, double target) {
        int res = root.val;

        if (res - target == 0)
            return res;

        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(res - target)) {
                res = root.val;
            }
            if (target > root.val) {
                root = root.right;
            } else if (target < root.val) {
                root = root.left;
            } else {
                return root.val;
            }
        }
        return res;
    }


}
