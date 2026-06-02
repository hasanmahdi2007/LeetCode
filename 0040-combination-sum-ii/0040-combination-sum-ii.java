class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> arr = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, arr, new ArrayList<>());
        return arr;
    }

    public void helper(int[] candidates, int target, int i, List<List<Integer>> arr,ArrayList<Integer> a){
        if(target == 0) {
            arr.add(new ArrayList<Integer>(a));
            return;
        }
        if(i == candidates.length) {
            return;
        }
        if (candidates[i] > target) return;
        a.add(candidates[i]);
        helper(candidates, target - candidates[i], i + 1, arr, a);
        a.remove(a.size() - 1);
        while(i + 1 < candidates.length && candidates[i] == candidates[i+1]) i++;
        helper(candidates, target, i+1, arr, a);
    }
} 
