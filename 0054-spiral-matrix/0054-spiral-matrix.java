class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = n - 1;
        int down = m - 1;
        int up = 0;
        List<Integer> l = new ArrayList<>();
        while((left <= right && up <= down)){
            for(int j = left; j <= right; j++){
                l.add(matrix[up][j]);
            }
            up++;
            for(int i = up; i <= down; i++){
                l.add(matrix[i][right]);
            }
            right--;
            if (up <= down){
                for(int j = right; j >= left; j--){
                    l.add(matrix[down][j]);
                }
                down--;
            }
            if (left <= right){
                for(int i = down; i >= up; i--){
                    l.add(matrix[i][left]);
                }
                left++;
            }    
        }
        return l;
    }
}