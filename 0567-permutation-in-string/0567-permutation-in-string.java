class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 > n2) return false;
        int[] s1Counts = new int[26];
        int[] s2Counts = new int[26];
        for (int i = 0; i < n1; i++) {
            s1Counts[s1.charAt(i) - 'a']++;
            s2Counts[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Counts[i] == s2Counts[i]) matches++;
        }
        for (int i = n1; i < n2; i++) {
            if (matches == 26) return true;
            int rightIdx = s2.charAt(i) - 'a';
            int leftIdx = s2.charAt(i - n1) - 'a';
            s2Counts[rightIdx]++;
            if (s2Counts[rightIdx] == s1Counts[rightIdx]) {
                matches++; 
            } else if (s2Counts[rightIdx] == s1Counts[rightIdx] + 1) {
                matches--; 
            }
            s2Counts[leftIdx]--;
            if (s2Counts[leftIdx] == s1Counts[leftIdx]) {
                matches++;
            } else if (s2Counts[leftIdx] == s1Counts[leftIdx] - 1) {
                matches--;
            }
        }
        return matches == 26;
    }
}