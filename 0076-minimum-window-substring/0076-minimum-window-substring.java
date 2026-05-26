class Solution {
    public String minWindow(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if(n2 > n1) return "";
        int[] letters = new int[52];
        int[] s_letters = new int[52];
        for(int i = 0; i < n2; i++){
            char c = t.charAt(i);
            if(c >= 'a') letters[c - 'a' + 26]++;
            else letters[c - 'A']++;
        }
        int left = 0;
        int shortest = Integer.MAX_VALUE;
        String shortest_string = "";
        for(int i = 0; i < n1; i++){
            char c = s.charAt(i);
            if(c >= 'a') s_letters[c - 'a' + 26]++;
            else s_letters[c - 'A']++;
            while(fits(s_letters, letters) && left <= i){
                int length = i - left + 1;
                if(length < shortest) {
                    shortest = length;
                    shortest_string = s.substring(left,i+1);
                }
                char current = s.charAt(left);
                if(current >= 'a') s_letters[current - 'a' + 26]--;
                else s_letters[current - 'A']--;
                left++;
            } 
        }
        return shortest_string;
    }

    public boolean fits(int[] s_letters, int[] letters){
        for(int i = 0; i < 52; i++){
            if(letters[i] > s_letters[i] && letters[i] != 0) return false;
        }
        return true;
    }

}