class Solution {

    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                boolean found = helper(board, word, 0, i, j);
                if(found) return true;
            }
        }
        return false;        
    }

    public boolean helper(char[][] board, String word, int word_ind, int i, int j){
        if(word_ind == word.length()) return true;
        if(i == board.length || j == board[0].length || i == -1 || j == -1) return false;
        if(board[i][j] == '$') return false;
        
        char c = word.charAt(word_ind);
        if(c == board[i][j]) {
            board[i][j] = '$';
            boolean found = helper(board, word, word_ind+1, i, j+1) ||
                   helper(board, word, word_ind+1, i, j-1) ||
                   helper(board, word, word_ind+1, i+1, j) ||
                   helper(board, word, word_ind+1, i-1, j);
            board[i][j] = c;
            return found;
        }
        return false;
    }
}