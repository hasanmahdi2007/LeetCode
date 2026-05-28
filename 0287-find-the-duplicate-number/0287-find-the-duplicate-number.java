class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        int ind = nums[0];
        while(fast != slow){
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        ind =  slow;
        slow = 0;
        fast = ind;
        while(slow != fast){
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}