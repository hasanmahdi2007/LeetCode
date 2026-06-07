class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] pivot = null;
        for(int i = 0; i < triplets.length; i++){
            int[] current = triplets[i];
            if(target[0] >= current[0]
            && target[1] >= current[1]
            && target[2] >= current[2]){
                if(pivot == null) pivot = current;
                else {
                    if(current[0] >= pivot[0]) pivot[0] = current[0];
                    if(current[1] >= pivot[1]) pivot[1] = current[1];
                    if(current[2] >= pivot[2]) pivot[2] = current[2];
                }
            }
        }
        if(pivot == null) return false;
        else{
            for(int i = 0; i < 3; i++){
                if(pivot[i] != target[i]) return false;
            }
            return true;
        }
    }
}