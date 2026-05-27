class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int bounded_max = nums[n-1];
        int left = 0;
        int right = n-1;
        int candidate = bounded_max;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] >= bounded_max) left = mid + 1;
            else {
                candidate = nums[mid];
                right = mid - 1;
            } 
        }
        return candidate;
    }
}