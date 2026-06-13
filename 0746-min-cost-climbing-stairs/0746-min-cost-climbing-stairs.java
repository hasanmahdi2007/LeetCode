class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length+1];
        Arrays.fill(memo, -1);
        int index0 = helper(0, cost, memo);
        int index1 = helper(1, cost, memo);
        return Math.min(index0, index1);
    }
    public int helper(int i, int[] cost, int[] memo){
        if(i >= cost.length) return 0;
        if(memo[i] != -1) return memo[i];
        int oneStep = helper(i+1, cost, memo);
        int twoStep = helper(i+2, cost, memo);
        memo[i] = cost[i] + Math.min(oneStep, twoStep);
        return memo[i];
    }
}