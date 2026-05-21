class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] letters = new int[26];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            letters[c - 'a']++;
        }
        for(int i = 0; i < t.length(); i++){
            char d = t.charAt(i);
            if(letters[d - 'a']-- == 0) return false;
        }
        return true;
    }
}