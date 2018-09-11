import java.util.LinkedList;
import java.util.List;

public class combinationSum {
    /*
    39. Combination Sum
    Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

    The same repeated number may be chosen from candidates unlimited number of times.
    Note:
    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.
    Example 1:

    Input: candidates = [2,3,6,7], target = 7,
    A solution set is:
    [
      [7],
      [2,2,3]
    ]
    Example 2:

    Input: candidates = [2,3,5], target = 8,
    A solution set is:
    [
      [2,2,2,2],
      [2,3,3],
      [3,5]
    ]
     */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if(candidates==null||candidates.length==0)
            return res;
        helper(candidates, target, 0, res,new LinkedList<>());
        return res;
    }

    private void helper(int[] candidates, int target, int offset,List<List<Integer>> res, List<Integer> list){
        if(offset>=candidates.length)
            return;
        if(target==0){
            res.add(new LinkedList<>(list));
        }
        for(int i=0; i<candidates.length; i++){
            list.add(candidates[i]);
            helper(candidates, target-candidates[i], offset+1, res, list);
            list.remove(list.size()-1);
        }
    }
}
