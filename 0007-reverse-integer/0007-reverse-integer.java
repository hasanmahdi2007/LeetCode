class Solution {
    public int reverse(int x) {
        int newNum = 0;
        int digit = 0;
        while(x != 0){
            if(newNum > Integer.MAX_VALUE / 10 || (newNum == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
            if(newNum < Integer.MIN_VALUE / 10 || (newNum == Integer.MIN_VALUE / 10 && digit > 8)) return 0;
            digit = x % 10;
            x /= 10;
            newNum = newNum * 10 + digit;
        }
        return newNum;
    }
}