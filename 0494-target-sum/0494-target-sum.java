class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int num : nums) sum += num;
        int newTarget = 0;
        if(target < 0) newTarget = (sum - target);
        else newTarget = target + sum;
        if(newTarget % 2 != 0) return 0;
        newTarget = newTarget / 2;
        int[] dp = new int[newTarget+1];
        dp[0] = 1;
        for(int num : nums){
            for(int i = newTarget; i >= num; i--){
                dp[i] += dp[i - num];
            }
        }
        return dp[newTarget];
    }
}