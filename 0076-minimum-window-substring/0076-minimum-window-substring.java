class Solution {
    public String minWindow(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if(n2 > n1) return "";
        int[] letters = new int[52];
        int[] s_letters = new int[52];
        int unique = 0;
        for(int i = 0; i < n2; i++){
            char c = t.charAt(i);
            if(c >= 'a') {
                if(letters[c - 'a' + 26]++ == 0) unique++;
            }    
            else {
                if(letters[c - 'A']++ == 0) unique++;
            }    
        }
        int left = 0;
        int shortest = Integer.MAX_VALUE;
        String shortest_string = "";
        int fit = 0;
        int start = -1;
        int end = -1;
        for(int i = 0; i < n1; i++){
            char c = s.charAt(i);
            if(c >= 'a') {
                s_letters[c - 'a' + 26]++;
                if(s_letters[c - 'a' + 26] == letters[c - 'a' + 26]) fit++;
            }    
            else {
                s_letters[c - 'A']++;
                if(s_letters[c - 'A' ] == letters[c - 'A']) fit++;
            }    
            while(unique == fit && left <= i){
                int length = i - left + 1;
                if(length < shortest) {
                    shortest = length;
                    start = left;
                    end = i;
                }
                char current = s.charAt(left);
                if(current >= 'a') {
                    s_letters[current - 'a' + 26]--;
                    if(s_letters[current - 'a' + 26] < letters[current - 'a' + 26]) fit--;
                }    
                else {
                    s_letters[current - 'A']--;
                    if(s_letters[current - 'A'] < letters[current - 'A']) fit--;
                }    
                left++;
            } 
        }
        if (shortest == Integer.MAX_VALUE) return "";
        shortest_string = s.substring(start,end+1);
        return shortest_string;
    }
}