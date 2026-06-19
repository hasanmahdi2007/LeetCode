class Solution {
    public int getSum(int a, int b) {
        while (b != 0) { 
            int answerWithoutCarry = a ^ b;
            int carry = (a & b) << 1;       
            a = answerWithoutCarry; 
            b = carry;              
        }
        return a;
    }
}