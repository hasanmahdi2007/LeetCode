class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) s.add(nums[i]);
        int longest_count = 0;
        for(int i : s){
            if(s.contains(i-1)) continue;
            int counter = 1;
            while(s.contains(++i)) {
                counter++;
            }
            if(counter > longest_count) longest_count = counter;    
        }
        return longest_count;
    }
}