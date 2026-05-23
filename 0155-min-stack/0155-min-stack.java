class MinStack {
    int minimum = Integer.MAX_VALUE;
    LinkedList<int[]> s;
    public MinStack() {
        s = new LinkedList<>();
    }
    
    public void push(int val) {
        if(val < minimum) minimum = val;  
        s.addFirst(new int[] {val,minimum});     
    }
    
    public void pop() {
        s.removeFirst();
        if(s.isEmpty()) minimum = Integer.MAX_VALUE;
        else minimum = s.getFirst()[1];
    }
    
    public int top() {
        return s.getFirst()[0];
    }
    
    public int getMin() {
        return s.getFirst()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */