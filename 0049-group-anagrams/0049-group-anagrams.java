class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> L = new ArrayList<>();
        Map<String, Integer> m = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            int[] temp = new int[26];
            char[] c_arr = strs[i].toCharArray();
            for(char c : c_arr){
                temp[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int j : temp){
                sb.append(j + "");
                sb.append("#");
            }
            String s = sb.toString();
            if(m.containsKey(s)) L.get(m.get(s)).add(strs[i]);
            else {
                m.put(s, L.size());
                L.add(new ArrayList<String>(List.of(strs[i])));
            }    
        }
        return L;
    }
}