class WordDictionary {
    
    TrieNode root;

    private class TrieNode{
        TrieNode[] letters;
        boolean end;
        public TrieNode(){
            letters = new TrieNode[26];
        }
    }

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(current.letters[c - 'a'] == null) {
                current.letters[c - 'a'] = new TrieNode();
            }
            current = current.letters[c-'a'];
        }
        current.end = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        return searchHelper(word, 0, current);
    }

    public boolean searchHelper(String word, int start, TrieNode current){
        for(int i = start; i < word.length(); i++){
            char c = word.charAt(i);
            if(c == '.') {
                for(int j = 0; j < 26; j++){
                    if(current.letters[j] != null) {
                        if(searchHelper(word, i+1, current.letters[j]))
                            return true;
                    }
                }
                return false;
            }
            if(current.letters[c - 'a'] == null) return false;
            current = current.letters[c-'a'];
        }
        if(current.end) return true;
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */