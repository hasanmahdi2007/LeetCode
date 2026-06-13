class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        String answer = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                String sub = s.substring(i, j+1);
                if(isPalindrome(sub)) {
                    if(sub.length() > maxLength) {
                        maxLength = sub.length();
                        answer = sub;
                    }   
                }
            }
        }
        return answer;
    }

    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while(left < right){
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}