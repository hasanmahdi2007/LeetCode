class Solution {
    public int missingNumber(int[] nums) {
        int n = 0;
        for(int num : nums)
            n ^= num;
        for(int i = 0; i < nums.length+1; i++){
            n ^= i;
        }    
        return n;
    }
}