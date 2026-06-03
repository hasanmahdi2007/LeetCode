class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> arr = new ArrayList<>();
        helper(s, new ArrayList<String>(), arr, 0);
        return arr;
    }

    public void helper(String s, ArrayList<String> a, List<List<String>> arr, int start){
        if(start == s.length()) {
                arr.add(new ArrayList<String>(a));
                return;
        }
        for(int end = start; end < s.length(); end++){
            String s1 = s.substring(start, end+1);
            if(Palindrome(s1)) {
                a.add(s1);
                helper(s, a, arr, end+1);
                a.remove(a.size()-1);
            }    
        }
    }

    public boolean Palindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}