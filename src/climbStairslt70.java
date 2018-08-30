public class climbStairslt70 {

    /*
    70. Climbing Stairs

    You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    Input: 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps

    Input: 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step
     */

    public int climbStairs(int n) {

        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];      //# ways to climb n-1 steps and left 1 step is dp[i-1], # ways to climb n-2 steps and left 2 step2
        }

        return dp[n];
    }
}
