class Solution {
    public int calculate(String s) {
        int[] index = new int[1];
        return helper(s, index, 0);
    }

    public int helper(String s, int[] index, int ans){
        int num = 0;
        boolean neg = false;
        while(index[0] < s.length()){
            char c = s.charAt(index[0]++);
            if(c == '(') {
                if(!neg) ans += helper(s, index, 0);
                else ans -= helper(s, index, 0);
                neg = false;
            }
            if(c == ')') {
                if (neg) ans -= num;
                else ans += num;
                neg = false;
                return ans;
            }
            if(c >= '0' && c <= '9') num = (num * 10) + (c - '0');
            if(c == '+' || c == '-'){
                if(neg == true) ans -= num;
                else ans += num;
                num = 0;
                neg = (c == '-') ? true : false;
            }
        }
        if(neg == true) ans -= num;
        else ans += num;
        return ans;
    }
}