class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n];
        return helper(0, n, memo);
    }
    public int helper(int height, int n, int[] memo){
        if(height == n) return 1;
        if(height > n) return 0;
        if(memo[height] != 0) return memo[height];
        int oneStep = helper(height+1, n, memo);
        int twoStep = helper(height+2, n, memo);
        memo[height] = oneStep + twoStep;
        return memo[height];
    }
}