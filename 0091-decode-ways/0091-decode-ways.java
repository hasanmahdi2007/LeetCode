class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        if(s.length() == 1) return 1;
        int second = 1;
        int first = 1;
        int current = 0;
        for(int i = 1; i < s.length(); i++){
            current = 0;
            char c = s.charAt(i);
            int num = c - '0';
            int twoDigits = num + (s.charAt(i-1) - '0') * 10;
            if(twoDigits >= 10 && twoDigits <= 26) current += first;
            if(num > 0) current += second;
            first = second;
            second = current;
        }
        return current;
    }
}