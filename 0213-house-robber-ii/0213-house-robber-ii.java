class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int withFirst = firstPath(0, nums, memo);
        Arrays.fill(memo, -1);
        int withLast = secondPath(1, nums, memo);
        return Math.max(withFirst, withLast);
    }

    public int firstPath(int i, int[] nums, int[] memo){
        if(i >= nums.length-1) return 0;
        if(memo[i] != -1) return memo[i];
        int didntTake = firstPath(i+1, nums, memo);
        int took = nums[i] + firstPath(i+2, nums, memo);
        memo[i] = Math.max(didntTake, took);
        return memo[i];
    }

    public int secondPath(int i, int[] nums, int[] memo){
        if(i >= nums.length) return 0;
        if(memo[i] != -1) return memo[i];
        int didntTake = secondPath(i+1, nums, memo);
        int took = nums[i] + secondPath(i+2, nums, memo);
        memo[i] = Math.max(didntTake, took);
        return memo[i];
    }
}