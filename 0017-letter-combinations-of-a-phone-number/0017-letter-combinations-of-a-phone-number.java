class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letters = new String[10];
        List<String> result = new ArrayList<>();
        letters[2] = "abc";
        letters[3] = "def";
        letters[4] = "ghi";
        letters[5] = "jkl";
        letters[6] = "mno";
        letters[7] = "pqrs";
        letters[8] = "tuv";
        letters[9] = "wxyz"; 
        char c = digits.charAt(0);
        for(int i = 0; i < letters[c - '0'].length(); i++) 
            result.add(letters[c - '0'].charAt(i) + "");
        for(int i = 1; i < digits.length(); i++){
            List<String> result2= new ArrayList<String>();
            c = digits.charAt(i);
            String current = letters[c - '0'];
            for(int j = 0; j < current.length(); j++){
                c = current.charAt(j);
                for(int k = 0; k < result.size(); k++){
                    result2.add( result.get(k) + "" + c);
                }
            }
            result = result2;
        }
        return result;
    }
}