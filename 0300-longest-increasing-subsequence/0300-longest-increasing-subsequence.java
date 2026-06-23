class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] memo = new int[nums.length][nums.length];
        return dfs(nums, memo, 0, -1);
    }

    public int dfs(int[] nums, int[][] dp, int i, int prevInd){
        if(i >= nums.length) return 0;
        if(dp[i][prevInd + 1] != 0) return dp[i][prevInd+1];
        int skip = dfs(nums, dp, i+1, prevInd);
        int take = 0;
        if(prevInd == -1 || nums[prevInd] < nums[i]){
            take = dfs(nums, dp, i+1, i) + 1;
        }
        return dp[i][prevInd+1] = Math.max(take, skip);
    }
}