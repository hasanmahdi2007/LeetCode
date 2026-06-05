class Solution {
    public int leastInterval(char[] tasks, int n) {
        int max = Integer.MIN_VALUE;
        int num_of_max = 0;
        int[] freq = new int[26];
        for(char c : tasks){
            int ind = c-'A';
            if(++freq[ind] > max) {
                max = freq[ind];
                num_of_max = 1;
            }
            else if(freq[ind] == max) num_of_max++;    
        }
        int spaces = (max-1) * (n - (num_of_max - 1));
        if(spaces <= tasks.length - (max*num_of_max)) return tasks.length;
        else return tasks.length + (spaces - (tasks.length - (max*num_of_max)));
    }
}