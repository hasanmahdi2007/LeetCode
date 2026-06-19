class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        rotate(0, 0, matrix);
    }

    public void rotate(int i, int j, int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        if(j == n) {
            rotate(i+1, 0, matrix);
            return;
        }    
        if(i == m){
            return;
        }
        int num = matrix[i][j];
        rotate(i, j+1, matrix);
        matrix[j][n-1-i] = num;
    }
}