class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int withFirst = BackToTop(0,  nums.length-1, nums);
        int withLast = BackToTop(1, nums.length, nums);
        return Math.max(withFirst, withLast);
    }

    public int BackToTop(int start, int end, int[] nums){
        int maxValue = 0;
        int robberOne = 0;
        int robberTwo = 0;
        for(int i = start; i < end; i++){
            maxValue = Math.max(robberTwo, nums[i] + robberOne);
            robberOne = robberTwo;
            robberTwo = maxValue;
        }
        return maxValue;
    }
}