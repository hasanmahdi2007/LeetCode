class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int[] freq = new int[26];
        int maxFreq = 0;
        int currentMax = 0;
        while(right < s.length()){
            char letter = s.charAt(right);
            if(++freq[letter - 'A'] > currentMax) {
                currentMax = freq[letter - 'A'];
            }    
            if(right - left + 1 - currentMax <= k) {
                maxFreq = Math.max(maxFreq, right - left + 1);
            }
            else{
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return maxFreq;
    }
}