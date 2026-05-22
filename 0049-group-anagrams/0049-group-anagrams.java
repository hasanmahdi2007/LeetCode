class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> L = new ArrayList<>();
        Map<String, int[][]> m = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            int[] temp = new int[26];
            char[] c_arr = strs[i].toCharArray();
            for(char c : c_arr){
                temp[c - 'a']++;
            }
            boolean found = false;
            for(String s : m.keySet()){
                if(Arrays.equals(m.get(s)[0],temp)){
                    L.get(m.get(s)[1][0]).add(strs[i]);
                    found = true;
                    break; 
                }    
            }    
            if(!found) {
                int[][] arr = new int[2][1];
                arr[0] = temp;
                arr[1] = new int[] {L.size()};
                m.put(strs[i],arr);
                List<String> newGroup = new ArrayList<>();
                newGroup.add(strs[i]);
                L.add(newGroup);
            }   
        }
        return L;
    }
}