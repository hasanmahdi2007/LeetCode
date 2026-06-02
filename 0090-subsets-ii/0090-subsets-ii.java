class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<Integer>() , arr);
        return arr;
    }

    public void helper(int[] nums, int i, ArrayList<Integer> a, List<List<Integer>> arr){
        if(i == nums.length) {
            arr.add(new ArrayList<Integer>(a));
            return;
        }    
        a.add(nums[i]);
        helper(nums, i+1, a, arr);
        while(i+1 < nums.length && nums[i] == nums[i+1]) i++;
        a.remove(a.size() - 1);
        helper(nums, i+1, a, arr);
    }
}