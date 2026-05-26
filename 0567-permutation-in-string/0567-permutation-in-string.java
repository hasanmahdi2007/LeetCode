class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1_letters = new int[26];
        int n1 = s1.length();
        for(int i = 0; i < s1.length(); i++) {
            s1_letters[s1.charAt(i) - 'a']++;
        }
        int start = 0;
        for(int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            int asci = c - 'a';
            if(s1_letters[asci] != 0){
                s1_letters[asci]--;
                if(i - start + 1 == n1) return true;
            }
            else {  
                while(start < i){
                    s1_letters[s2.charAt(start) - 'a']++;
                    if(s1_letters[asci] > 0){
                        s1_letters[asci] = 0;
                        break;
                    }
                    start++; 
                }
                start++;
            }
        }    
        return false;
    }
}
