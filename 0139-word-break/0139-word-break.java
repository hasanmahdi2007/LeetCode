class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i < s.length()+1; i++){
            for(String word : wordDict){
                if(word.length() > i) continue;
                int start = i - word.length();
                if(dp[start] && s.substring(start, i).equals(word)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}