class Solution {
    public int singleNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int found = 0;
            for(int j = 0; j < nums.length; j++){
                if(nums[j] == nums[i]) found++;
            }
            if(found == 1) return nums[i];
        }
        return 0;
    }
}