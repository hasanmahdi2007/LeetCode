class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> arr = new ArrayList<>();
        boolean[] bools = new boolean[nums.length];
        helper(nums, bools, new ArrayList<Integer>(), arr);
        return arr;
    }

    public void helper(int[] nums, boolean[] bools, ArrayList<Integer> a, List<List<Integer>> arr){
        for(int i = 0; i < nums.length; i++){
            if(a.size() == nums.length) {
                arr.add(new ArrayList<Integer>(a));
                return;
            }        
            if(bools[i] == false){
                a.add(nums[i]);
                bools[i] = true;
                helper(nums,bools,a,arr);
                a.remove(a.size()-1);
                bools[i] = false;
            }
        }
        return;
    }
}   