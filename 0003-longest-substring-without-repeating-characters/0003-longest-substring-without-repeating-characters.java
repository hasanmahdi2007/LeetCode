class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[95];
        int start = 0;
        int max_subString = 0;
        int end = 1;
        if(s.length() == 0) return 0;
        else if(s.length() == 1) return 1;
        chars[s.charAt(0) - 32] = 1;
        for(int i = 1; i < s.length(); i++){
            end = i;
            char c = s.charAt(i);
            int place = c - 32;
            if(!((chars[place] - 1 < start) || (chars[place] == 0))) {
                int length = end - start;
                if(length > max_subString) max_subString = length;
                start = chars[place]; 
            }    
            chars[place] = i+1;
        }
        if(start != s.length()- 1) {
            int length = end + 1 - start;
            if(length > max_subString) max_subString = length;
        }    
        return max_subString;
    }
}