class Solution {
    public int minEatingSpeed(int[] piles, int h){
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            if (pile > right) right = pile;
        }
        int answer = right;
        while(left <= right){
            int mid = (left + right) / 2;
            int counter = 0;
            for(int i = 0; i < piles.length; i++){
                counter += (piles[i] + mid - 1) / mid;
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