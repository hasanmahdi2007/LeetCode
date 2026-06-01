class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();
        helper(nums, 0, new ArrayList<Integer>(), arr);
        return arr;
    }

    public void helper(int[] nums, int index, ArrayList<Integer> a, List<List<Integer>> arr){
        if(index == nums.length) {
            arr.add(new ArrayList<>(a));
            return;
        }    
        a.add(nums[index]);
        helper(nums, index+1, a, arr);
        a.remove(a.size()-1);
        helper(nums, index+1, a, arr);
    }
}