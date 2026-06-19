class Solution {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do{
            fast = sumOfDigits(sumOfDigits(fast));
            slow = sumOfDigits(slow);
            if(fast == 1) return true;
        } while(slow != fast);
        return false;
    }

    public int sumOfDigits(int n){
        int sum = 0;
        while(n > 0){
            int dig = n % 10;
            sum += dig * dig;
            n /= 10;
        }
        return sum;
    }
}