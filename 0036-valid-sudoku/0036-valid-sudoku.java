class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] blocks = new boolean[9][9];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == '.') continue;
                int num = (board[i][j] - '0') - 1;
                if(rows[i][num]) return false;
                rows[i][num] = true;
                if(cols[j][num]) return false;
                cols[j][num] = true;
                if(i < 3){
                    if(j < 3){
                        if(blocks[0][num]) return false;
                        blocks[0][num] = true;
                    }
                    else if(j < 6){
                        if(blocks[1][num]) return false;
                        blocks[1][num] = true;
                    }
                    else if(j < 9){
                        if(blocks[2][num]) return false;
                        blocks[2][num] = true;
                    }
                }
                if(i > 2 && i < 6){
                    if(j < 3){
                        if(blocks[3][num]) return false;
                        blocks[3][num] = true;
                    }
                    else if(j < 6){
                        if(blocks[4][num]) return false;
                        blocks[4][num] = true;
                    }
                    else if(j < 9){
                        if(blocks[5][num]) return false;
                        blocks[5][num] = true;
                    }
                }
                if(i > 5){
                    if(j < 3){
                        if(blocks[6][num]) return false;
                        blocks[6][num] = true;
                    }
                    else if(j < 6){
                        if(blocks[7][num]) return false;
                        blocks[7][num] = true;
                    }
                    else if(j < 9){
                        if(blocks[8][num]) return false;
                        blocks[8][num] = true;
                    }
                }
            }
        }
        return true;
    }
}