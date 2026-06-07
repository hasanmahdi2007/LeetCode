class Solution {
    public boolean canJump(int[] nums) {
        if(nums[0] == 0 && nums.length != 1) return false;
        int steps = nums[0] - 1;
        for(int i = 1; i < nums.length-1; i++){
            if (nums[i] > steps) {
                steps = nums[i];
            }
            if(steps <= 0) return false;
            steps--;
        }
        return true;
    }
}