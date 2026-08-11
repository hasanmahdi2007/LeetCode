class Solution {
    public int totalNQueens(int n) {
        ArrayList<int[]> queens = new ArrayList<>();
        int[] total = new int[1];
        helper(queens, total, n, 1);
        return total[0];
    }

    private void helper(ArrayList<int[]> queens, int[] total, int n, int row){
        if(queens.size() == n){
            total[0]++;
            return;
        }

        for(int i = 1; i <= n; i++){
            boolean suitable = true;
            for(int[] queen : queens){
                if(queen[1] == i || (Math.abs(queen[0] - row) == Math.abs(queen[1] - i))){
                    suitable = false;
                    break;
                }
            }
            if(suitable){
                queens.add(new int[]{row, i});
                helper(queens, total, n, row+1);
                queens.remove(queens.size()-1);
            }
        }
    }
}