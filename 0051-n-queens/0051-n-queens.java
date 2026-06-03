class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> arr = new ArrayList<>();
        helper(n, arr, new ArrayList<int[]>(), 0);
        return arr;
    }

    public void helper(int n, List<List<String>> arr, ArrayList<int[]> a, int i){
        boolean skip = false;
        if(i == n) {
            arr.add(boardBuilder(n, a));
            return;
        }    
        for(int j = 0; j < n; j++){
            for(int[] queens: a){
                if(j == queens[1] || (Math.abs(queens[0] - i)) == Math.abs(queens[1] - j)) {
                    skip = true;
                    break;
                }
            }
            if(skip) {
                skip = false;
                continue;
            }    
            a.add(new int[] {i, j});
            helper(n, arr, a, i+1);
            a.remove(a.size()-1);   
        }
    }

    public List<String> boardBuilder(int n, ArrayList<int[]> a) {
        List<String> board = new ArrayList<>();
        for (int[] queen : a) {
            int qcolumn = queen[1];
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < n; c++) {
                if (c == qcolumn) sb.append('Q');
                else sb.append('.');
            }
            board.add(sb.toString());
        }
        return board;
    }
}