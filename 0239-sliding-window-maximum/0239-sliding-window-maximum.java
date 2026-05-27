class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int size = (n - k) + 1;
        int max = 0;
        int[] results = new int[size];
        ArrayDeque<Integer> L = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            while(!L.isEmpty() && nums[i] >= nums[L.peekFirst()]){
                L.removeFirst();
            }
            L.addFirst(i);
            if(i - L.getLast() == k) L.removeLast();
            if(i >= k - 1) results[i - (k - 1)] = nums[L.getLast()];
        }
        return results;
    }
}