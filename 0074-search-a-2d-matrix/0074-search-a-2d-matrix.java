class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length-1;
        int ind = -1;
        while(right >= left){
            int mid = (right + left) / 2;
            if (matrix[mid][0] > target) {
                if(mid == 0) return false;
                else{
                    if(matrix[mid-1][0] < target) {
                        ind = mid-1;
                        break;
                    } else right = mid - 1;   
                }
            } else if (matrix[mid][0] == target) return true;
            else {
                if(mid == matrix.length-1) {
                    ind = mid;
                    break;
                }
                else {
                    if(matrix[mid + 1][0] > target) {
                        ind = mid;
                        break;
                    } else{
                        left = mid + 1;
                    }
                }
            }
        }
        if(ind == -1) return false;
        int[] arr = matrix[ind];
        left = 0;
        right = matrix[ind].length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] == target) return true;
            else if(arr[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return false; 
    }
}