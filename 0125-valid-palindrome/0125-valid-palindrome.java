class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c >= 'A' && c <= 'Z') c = Character.toLowerCase(c);
            if(( c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) sb.append(c);
        }
        if(sb.length() == 0) return true;
        String sb1 = sb.toString();
        n = sb1.length();
        int left = n/2;
        int right = n / 2;
        if(n % 2 == 0) left = n/2 - 1;
        for(int i = right; i < n; i++){
            if(sb1.charAt(left--) != sb1.charAt(right++)) return false;
        } return true;
    } 
}