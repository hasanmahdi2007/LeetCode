class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        generateCombinations(answer, new ArrayList<Integer>(), n, k, 1);
        return answer;
    }

    public void generateCombinations(List<List<Integer>> ans, List<Integer> current, int n, int k, int start){
        if(current.size() == k){
            ans.add(new ArrayList<Integer>(current));
            return;
        }
        for(int i = start; i <= n; i++){
            current.add(i);
            generateCombinations(ans, current, n, k, i+1);
            current.remove(current.size()-1);
        }
    }
}