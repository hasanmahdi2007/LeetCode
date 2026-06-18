class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length()][word2.length()];
        for(int i = 0; i < word1.length(); i++)
            Arrays.fill(memo[i], -1);
        return dfs(0, 0, word1, word2, memo);
    }   

    public int dfs(int i, int j, String word1, String word2, int[][] memo){
        if (i == word1.length()) return word2.length() - j;
        if (j == word2.length()) return word1.length() - i;
        if(memo[i][j] != -1) return memo[i][j];
        if(word1.charAt(i) == word2.charAt(j)) {
            return memo[i][j] = dfs(i+1, j+1, word1, word2, memo);
        }
        int delete = dfs(i+1, j, word1, word2, memo);
        int replace = dfs(i+1, j+1, word1, word2, memo);
        int insert = dfs(i, j+1, word1, word2, memo);
        return memo[i][j] = 1 + Math.min(delete, Math.min(replace, insert));
    }
}