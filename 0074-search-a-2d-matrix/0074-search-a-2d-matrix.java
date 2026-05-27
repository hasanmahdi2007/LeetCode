class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int full_size = n * m;
        int right = full_size - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            int arr = mid / m;
            int new_mid = mid % m;
            if(matrix[arr][new_mid] == target) return true;
            else if (matrix[arr][new_mid] < target) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return false;
    }    
}