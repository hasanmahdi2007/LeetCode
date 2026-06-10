class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, ArrayList<String>> keywords = new HashMap<>();
        HashMap<String, ArrayList<String>> substrings = new HashMap<>();
        wordList.add(beginWord);
        for(int i = 0; i < wordList.size(); i++){
            wordOrganizer(wordList.get(i), keywords, substrings);
        }
        HashMap<String, HashSet<String>> similars = new HashMap<>();
        for(int i = 0; i < wordList.size(); i++){
            String word = wordList.get(i);
            similars.put(word, new HashSet<String>());
            for(String keyword : keywords.get(word)){
                ArrayList<String> neighbors = substrings.get(keyword);
                for(String sim : neighbors){
                    if(!similars.get(word).contains(sim))
                        similars.get(word).add(sim);
                }
            }
        }
        return bfs(beginWord, endWord, similars);
    }

    
    public int bfs(String beginWord, String endWord, HashMap<String, HashSet<String>> similars){
        ArrayDeque<String> q = new ArrayDeque<>();
        q.offer(beginWord);
        int ladder = 1;
        HashSet<String> dups = new HashSet<>();
        int step = 1;
        while(!q.isEmpty()){
            String current = q.removeFirst();
            HashSet<String> sims = similars.get(current);
            if(sims.contains(endWord)) return ladder+1;
            for(String link : sims){
                if(!dups.contains(link)) {
                    q.offer(link);
                    dups.add(link);
                }    
            }
            step--;
            if(step == 0) {
                ladder++;
                step = q.size();
            }    
        }
        return 0;
    }

    //method i should call whie looping the wordList for the first time
    public void wordOrganizer(String s, HashMap<String, ArrayList<String>> keywords, HashMap<String,ArrayList<String>> substrings){
        keywords.put(s, new ArrayList<String>());
        for(int i = 0; i < s.length(); i++){
            StringBuilder keyword = new StringBuilder();
            keyword.append(s.substring(0,i));
            keyword.append("*");
            keyword.append(s.substring(i+1, s.length()));
            String sKeyword = keyword.toString();
            keywords.get(s).add(sKeyword);
            if(!substrings.containsKey(sKeyword)){
                substrings.put(sKeyword, new ArrayList<String>());
            }
            substrings.get(sKeyword).add(s);
        }
    }
}