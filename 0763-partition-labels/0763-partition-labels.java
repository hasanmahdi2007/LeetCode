class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] first = new int[26];
        Arrays.fill(first,-1);
        Deque<int[]> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(first[c - 'a'] == -1){
                first[c - 'a'] = i;
                stack.push(new int[] {i,i});
            }
            else {
                while(stack.peek()[0] > first[c-'a']){
                    stack.pop();
                }
                stack.peek()[1] = i;
            }
        }
        List<Integer> results = new ArrayList<>();
        while(!stack.isEmpty()){
            int[] current = stack.removeLast();
            results.add(current[1] - current[0] + 1);
        }
        return results;
    }
}