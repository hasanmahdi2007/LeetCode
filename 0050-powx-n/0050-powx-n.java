class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(N >= 0) return posPow(x, N);
        return 1 / (posPow(x,Math.abs(N)));
    }

    public double posPow(double x, long n){
        if(n == 0) return 1;
        if(n == 1) return x;
        double result = 1;
        double current = x;
        while(n > 0){
            if(n % 2 == 1){
                result *= current;
            }
            current *= current;
            n /= 2;
        }
        return result;
    }
}