class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> L = new ArrayList<>();
        Map<String, Integer> m = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] letters = strs[i].toCharArray();
            Arrays.sort(letters);
            String s = new String(letters);
            if(m.containsKey(s)) L.get(m.get(s)).add(strs[i]);
            else{
                m.put(s, L.size());
                List<String> tempo = new ArrayList<>();
                tempo.add(strs[i]);
                L.add(tempo);
            }
        }
        return L;
    }
}