class Solution {
    public int jump(int[] nums) {
        int i = 0;
        int jumps = 0;
        if(nums.length == 1) return 0;
        int best_jump = nums[0];
        while(i < nums.length){
            if(nums[i] > best_jump) best_jump = nums[i];
            if(i + best_jump >= nums.length-1) {
                jumps++;
                break;
            }    
            int checkPoint = i + best_jump;
            while(i < checkPoint){
                if(best_jump < (nums[i])){
                    best_jump = nums[i];
                }
                best_jump--;
                i++;
            }
            jumps++;
        }
        return jumps;
    }
}