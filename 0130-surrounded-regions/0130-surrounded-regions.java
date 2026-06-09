class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] mark = new boolean[m][n];
        for(int c = 0; c < n; c++) 
            if(board[0][c] == 'O')
                Marker(board, 0, c, mark);
        for(int r = 0; r < m; r++)
            if(board[r][0] == 'O')
                Marker(board, r, 0, mark);
        for(int c = 0; c < n; c++) 
            if(board[m-1][c] == 'O')
                Marker(board, m-1, c, mark);
        for(int r = 0; r < m; r++)
            if(board[r][n-1] == 'O')
                Marker(board, r, n-1, mark);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!mark[i][j]) board[i][j] = 'X';
            }
        }
    }

    public void Marker(char[][] board, int i, int j, boolean[][] mark){
        if(i == -1 || j == -1 || i == board.length || j == board[0].length) return;
        if(board[i][j] == 'X' || mark[i][j]) return;
        else mark[i][j] = true;
        Marker(board, i-1, j, mark);
        Marker(board, i+1, j, mark);
        Marker(board, i, j-1, mark);
        Marker(board, i, j+1, mark);
    }
}