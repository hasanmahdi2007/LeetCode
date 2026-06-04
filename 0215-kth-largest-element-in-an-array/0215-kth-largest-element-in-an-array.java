class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, nums.length - k, 0, nums.length-1);
    }

    public int quickSelect(int[] nums, int target, int left, int right){
        int pivot = nums[(left + right) / 2];
        int i = left;
        int j = right;
        while(i <= j){
            while(nums[j] > pivot) j--;
            while(nums[i] < pivot) i++;

            if(i <= j){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j--;
            }
        }
        if(target <= j){
            return quickSelect(nums, target, left, j);
        } else if(target >= i) return quickSelect(nums, target, i, right);
        else return nums[target];
    }
}