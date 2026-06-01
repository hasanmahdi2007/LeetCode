class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> arr = new ArrayList<>();
        helper(candidates, target, arr, new ArrayList<Integer>(), 0, 0);
        return arr;
    }

    public void helper(int[] candidates, int target, List<List<Integer>> arr, ArrayList<Integer> a, int score, int index){
        if(index == candidates.length) {;
            if(score == target)
                arr.add(new ArrayList<>(a));
            return;    
        }
        if(score > target) return;
        a.add(candidates[index]);
        helper(candidates, target, arr, a, score + candidates[index], index);
        a.remove(a.size()-1);
        helper(candidates, target, arr, a, score, index+1);
    }
}