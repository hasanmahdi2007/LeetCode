class Trie {
    TrieNode head;
    private class TrieNode{
        TrieNode[] arr;
        boolean end;
        public TrieNode(){
            arr = new TrieNode[26];
            end = false;
        }
    }

    public Trie() {
        head = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = head;
        int n = word.length();
        for(int i = 0; i < n; i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if(current.arr[index] == null){
                current.arr[index] = new TrieNode();
            }
            current = current.arr[index];
            if(i == n-1) current.end = true;
        }
    }
    
    public boolean search(String word) {
        TrieNode current = head;
        int n = word.length();
        for(int i = 0; i < n; i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if(current.arr[index] == null){
                return false;
            }
            current = current.arr[index];
            if(i == n-1) return current.end;
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = head;
        int n = prefix.length();
        for(int i = 0; i < n; i++){
            char c = prefix.charAt(i);
            int index = c - 'a';
            if(current.arr[index] == null){
                return false;
            }
            current = current.arr[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */