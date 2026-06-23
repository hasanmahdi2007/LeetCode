class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] padded = new int[n+2];
        padded[0] = 1;
        padded[n+1] = 1;
        for(int i=0; i<n; i++) {
            padded[i+1] = nums[i];
        }
        int[][] dp = new int[n+2][n+2];
        return dfs(padded, dp, 1, n);
    }
    private int dfs(int[] nums, int[][] dp, int left, int right) {
        if(left > right) return 0;
        if(dp[left][right] != 0) return dp[left][right];
        int maxCoins = 0;
        for(int k=left; k<=right; k++) {
            int current = nums[left-1] * nums[k] * nums[right+1];
            int total = current + dfs(nums, dp, left, k-1) + dfs(nums, dp, k+1, right);
            maxCoins = Math.max(maxCoins, total);
        }
        return dp[left][right] = maxCoins;
    }
}