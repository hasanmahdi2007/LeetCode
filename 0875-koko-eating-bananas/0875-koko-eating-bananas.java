class Solution {
    public int minEatingSpeed(int[] piles, int h){
        int left = 0;
        int right = 0;
        for (int pile : piles) {
            if (pile > right) right = pile;
        }
        int answer = right;
        while(left <= right){
            int mid = (left + right) / 2;
            int counter = 0;
            for(int i = 0; i < piles.length; i++){
                counter += Math.ceil(1.0 * piles[i] / mid);
                if(counter > h) break;
            }
            if(counter <= h) {
                answer = mid;
                right = mid - 1;
            } 
            else left = mid + 1;
        }
        return answer;
    }
}