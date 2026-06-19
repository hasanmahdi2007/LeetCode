class Solution {
    public int reverseBits(int n) {
        int newNum = 0;
        for(int i = 0; i < 32; i++){
            int rightBit = 1 & n;
            newNum = (newNum << 1) | rightBit;
            n >>>= 1;
        }
        return newNum;
    }
}