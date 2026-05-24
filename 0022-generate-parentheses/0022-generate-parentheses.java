class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> L = new ArrayList<>();
        helper(n,L,sb,0,0); 
        return L;
    }

    private void helper(int n, List<String> L, StringBuilder sb, int openers, int closers){
        if(closers == n) {
            L.add(sb.toString());
            return;
        }
        else{
            if(closers >= openers) {
                helper(n,L,sb.append("("),openers+1,closers);
                sb.deleteCharAt(sb.length()-1);
            }    
            else if(openers == n) {
                helper(n,L,sb.append(")"),openers,closers+1);
                sb.deleteCharAt(sb.length()-1);
            }    
            else {
                helper(n,L,sb.append("("),openers+1,closers);
                sb.deleteCharAt(sb.length()-1);
                helper(n,L,sb.append(")"),openers,closers+1);
                sb.deleteCharAt(sb.length()-1);
            }    
        }
    }
}