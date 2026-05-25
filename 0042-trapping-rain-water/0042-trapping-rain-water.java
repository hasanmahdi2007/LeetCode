class Solution {
    private class Node{
        public Deque<Integer> d;
        public int index;

        public Node(int index){
            this.index = index;
            d = new ArrayDeque<>();
        }
    }
    public int trap(int[] height) {
        Deque<Node> s = new ArrayDeque<>();
        int water_drops = 0;
        s.push(new Node(0));
        for(int i = 1; i < height.length; i++){
            Node past = s.peek();
            if(height[past.index] > height[i]){
                if(past.d.isEmpty()) past.d.push(i);
                else{
                    int current = i;
                    while(!past.d.isEmpty() && height[current] >= height[past.d.peek()]){
                        water_drops += (height[current] - height[past.d.peek()]) * (current - past.d.peek());
                        height[past.d.peek()] = height[current];
                        current = past.d.peek();
                        past.d.pop();
                    }
                    past.d.push(current);
                } 
            }
            else {
                int current = i;
                while(!past.d.isEmpty() && height[current] >= height[past.d.peek()]){
                    water_drops += (height[s.peek().index] - height[past.d.peek()]) * (current - past.d.peek());
                    height[past.d.peek()] = height[current];
                    current = past.d.peek();
                    past.d.pop();
                }
                s.push(new Node(current));
            }
        }
        return water_drops;
    }
}