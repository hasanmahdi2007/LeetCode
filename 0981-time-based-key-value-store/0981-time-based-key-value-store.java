class TimeMap {

    Map<String, TimePackage> m;

    private class TimePackage{
        ArrayList<String> s;
        ArrayList<Integer> i;

        public TimePackage(){
            s = new ArrayList<>();
            i = new ArrayList<>();
        }
    }
    
    public TimeMap() {
        m = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(m.containsKey(key)) {
            m.get(key).s.add(value);
            m.get(key).i.add(timestamp);
        }    
        else {
            TimePackage t = new TimePackage();
            t.s.add(value);
            t.i.add(timestamp);
            m.put(key, t);
        }    
    }
    
    public String get(String key, int timestamp) {
        if(!m.containsKey(key)) return "";
        ArrayList<String> s = m.get(key).s;
        ArrayList<Integer> i = m.get(key).i;
        int left = 0;
        int right = i.size()-1;
        String candidate = "";
        while(left <= right){
            int mid = (left + right) / 2;
            int current = i.get(mid);
            if(current == timestamp) return s.get(mid);
            else if(current > timestamp) right = mid - 1;
            else {
                candidate = s.get(mid);
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