class Solution {

    TrieNode root = new TrieNode();

    private class TrieNode{

        TrieNode[] letters;
        String word;

        public TrieNode(){
            letters = new TrieNode[26];
        }

    }

    public List<String> findWords(char[][] board, String[] words) {
        for(String word : words){
            TrieNode current = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(current.letters[c - 'a'] == null){
                    current.letters[c - 'a'] = new TrieNode();
                }
                current = current.letters[c - 'a'];
            }
            current.word = word;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(i, j, board, root, visited, set);
            }
        }
        List<String> ans = new ArrayList<>();
        for(String word : set) ans.add(word);
        return ans;
    }

    public void dfs(int i, int j, char[][] board, TrieNode current, boolean[][] visited, HashSet<String> set){
        if(i < 0 || i == board.length || j < 0 || j == board[0].length) return;
        if(visited[i][j]) return;
        visited[i][j] = true;
        char letter = board[i][j];
        if(current.letters[letter - 'a'] == null) {
            visited[i][j] = false;
            return;
        }    
        current = current.letters[letter - 'a'];
        if(current.word != null) set.add(current.word);
        dfs(i+1, j, board, current, visited, set);
        dfs(i-1, j, board, current, visited, set);
        dfs(i, j+1, board, current, visited, set);
        dfs(i, j-1, board, current, visited, set);
        visited[i][j] = false;
    }
}