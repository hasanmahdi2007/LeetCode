class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        boolean allZero = true;
        boolean hasTwoZeros = false;
        boolean hasZero = false;
        int[] answer = new int[nums.length];
        for(int i : nums) {
            if(i != 0) {
                allZero = false;
                product *= i;
            }    
            else {
                if(hasZero) hasTwoZeros = true;
                hasZero = true;
            }    
        }
        if(allZero || hasTwoZeros)  return answer; 
        for(int j = 0; j < answer.length; j++) {
            if(nums[j] == 0) answer[j] = product;
            else {
                if(hasZero) continue;
                else answer[j] = product / nums[j];
            }
        }    
        return answer;
    }
}