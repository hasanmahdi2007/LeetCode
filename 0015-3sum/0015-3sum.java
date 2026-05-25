class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> L = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int first = nums[i];
            if(i != 0) {
                if(nums[i] == nums[i-1]) continue; 
            }
            int left = 0;
            int right = nums.length-1;
            int target = 0 - first;
            while(left < right){
                if (left == i) left++;
                if (right == i) right--;
                if (left >= right) break;
                int result = nums[left] + nums[right];
                if (result == target) {
                    List<Integer> L1 = new ArrayList<>();
                    L1.add(first);
                    L1.add(nums[left]);
                    L1.add(nums[right]);
                    Collections.sort(L1);
                    if(!s.contains(L1)) {
                        L.add(L1);
                        s.add(L1);
                    }    
                    while(left < right && nums[left] == nums[left+1] && left - 1 != i) left++;
                    left++;
                }
                else if (result < target) {
                    while(left < right && nums[left] == nums[left+1] && left - 1 != i) left++;
                    left++;
                }    
                else {
                    while(left < right && nums[right] == nums[right-1] && right + 1 != i) right--;
                    right--;
                }    
            }
        }
        return L;    
    }
}