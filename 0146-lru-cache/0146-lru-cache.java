class LRUCache {
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;
    class Node{
        Node prev;
        Node next;
        int key;
        int value;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        this.head = new Node(-1, 0);
        this.tail = new Node(-1, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node current = map.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        Node newHead = current;
        newHead.next = head.next;
        head.next.prev = newHead;
        head.next = newHead;
        newHead.prev = head;
        return map.get(key).value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node current = map.get(key);
            current.value = value;
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current.next = head.next;
            head.next.prev = current;
            head.next = current;
            current.prev = head;
            return;
        }
        if(map.size() == capacity){
            map.remove(tail.prev.key);
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
        }
        Node newNode = new Node(key, value);
        newNode.next = head.next;
        head.next.prev = newNode;
        head.next = newNode;
        newNode.prev = head;
        map.put(key, newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */