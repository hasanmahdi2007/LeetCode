class Solution {
    public boolean isMatch(String s, String p) {
        Boolean memo[][] = new Boolean[s.length()][p.length()];
        return dfs(0, 0, s, p, memo);
    }

    public boolean dfs(int i, int j, String s, String p, Boolean[][] memo){
        if(i == s.length() && j == p.length()) return true;
        if(j == p.length()) return false;
        if(i == s.length()){
            if(j != p.length()-1 && p.charAt(j+1) == '*')
                return dfs(i, j+2, s, p, memo);
            else return false;   
        }
        if(memo[i][j] != null) return memo[i][j];
        if(j != p.length()-1 && p.charAt(j+1) == '*'){
            if(p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
                boolean stay = dfs(i+1, j, s, p, memo);
                boolean next = dfs(i+1, j+2, s, p, memo);
                boolean ignore = dfs(i, j+2, s, p, memo);
                return memo[i][j] = stay || next || ignore;
            }    
            else return memo[i][j] = dfs(i, j+2, s, p, memo);
        }
        if(p.charAt(j) == '.') return memo[i][j] = dfs(i+1, j+1, s, p, memo);
        if(s.charAt(i) == p.charAt(j)) return memo[i][j] = dfs(i+1, j+1, s, p, memo);
        return false;
    }
}