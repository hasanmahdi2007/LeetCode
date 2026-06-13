class Solution {
    public int rob(int[] nums) {
        int memo[] = new int[nums.length];
        Arrays.fill(memo, -1);
        return helper(0, nums, memo);
    }

    public int helper(int i, int[] nums, int[] memo){
        if(i >= nums.length) return 0;
        if(memo[i] != -1) return memo[i];
        int robNow = nums[i] + helper(i+2, nums, memo);
        int dontRob = helper(i+1, nums, memo);
        memo[i] = Math.max(robNow, dontRob);
        return memo[i];
    }
}