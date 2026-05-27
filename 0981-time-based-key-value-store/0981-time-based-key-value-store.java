class TimeMap {

    Map<String, ArrayList<Node>> m;

    private class Node{
        int time;
        String value;
        public Node(String value, int time){
            this.time = time;
            this.value = value;
        }
    }
    
    public TimeMap() {
        m = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(m.containsKey(key)) m.get(key).add(new Node(value,timestamp));
        else {
            ArrayList<Node> a = new ArrayList<Node>();
            a.add(new Node(value, timestamp));
            m.put(key, a);
        }    
    }
    
    public String get(String key, int timestamp) {
        if(!m.containsKey(key)) return "";
        ArrayList<Node> a = m.get(key);
        int left = 0;
        int right = a.size()-1;
        String candidate = "";
        while(left <= right){
            int mid = (left + right) / 2;
            Node current = a.get(mid);
            if(current.time == timestamp) return current.value;
            else if(current.time > timestamp) right = mid - 1;
            else {
                candidate = current.value;
                left = mid + 1;
            }
        }
        return candidate;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */