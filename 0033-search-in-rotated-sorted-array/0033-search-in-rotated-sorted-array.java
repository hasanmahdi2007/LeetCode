class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int last = nums[n-1];
        int left = 0;
        int right = n-1;
        boolean bigger = true;
        if(target <= last) bigger = false;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            if(bigger){
                if(nums[mid] > target || nums[mid] < last) right = mid - 1;
                else left = mid + 1;
            } else {
                if(nums[mid] < target || nums[mid] > last ) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
}