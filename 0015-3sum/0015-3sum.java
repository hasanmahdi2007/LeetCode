class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> L = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int first = nums[i];
            if(i != 0) {
                if(nums[i] == nums[i-1]) continue; 
            }
            int left = i + 1;
            int right = nums.length-1;
            int target = 0 - first;
            while(left < right){
                int result = nums[left] + nums[right];
                if (result == target) {
                    L.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]) left++;
                    left++;
                }
                else if (result < target) {
                    while(left < right && nums[left] == nums[left+1]) left++;
                    left++;
                }    
                else {
                    while(left < right && nums[right] == nums[right-1]) right--;
                    right--;
                }    
            }
        }
        return L;    
    }
}