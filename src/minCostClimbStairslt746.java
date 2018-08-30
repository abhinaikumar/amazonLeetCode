public class minCostClimbStairslt746 {
    /*
    746. Min Cost Climbing Stairs

    On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

    Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor,
    and you can either start from the step with index 0, or the step with index 1.

    Input: cost = [10, 15, 20]
    Output: 15
    Explanation: Cheapest is start on cost[1], pay that cost and go to the top.

    Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
    Output: 6
    Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
     */
    /*
    The problem is to climb all stairs, not to reach at n-th stairs. little different with leetcode70
    idea:climb stairs with min cost,which means finish climbing at nth stairs or n-1th stairs.
     */
    public int minCostClimbingStairs(int[] cost) {

        for(int i=2; i<cost.length; i++){
            cost[i]+=Math.min(cost[i-1],cost[i-2]);
        }
        return Math.min(cost[cost.length-1], cost[cost.length-2]);
    }


}
