class Solution {
    public int minEatingSpeed(int[] piles, int h){
        int left = 0;
        int right = Integer.MAX_VALUE;
        while(left <= right){
            int mid = (left + right) / 2;
            int counter = 0;
            for(int i = 0; i < piles.length; i++){
                counter += Math.ceil(1.0 * piles[i] / mid);
                if(counter > h) break;
            }
            if(counter <= h) {
                int mid2 = mid - 1;;
                int counter2 = 0;
                for(int i = 0; i < piles.length; i++){
                    counter2 += Math.ceil(1.0 * piles[i] / mid2);
                    if(counter2 > h) break;
                }
                if(counter2 > h) return mid;
                right = mid - 1;
            } 
            else left = mid + 1;
        }
        return 0;
    }
}