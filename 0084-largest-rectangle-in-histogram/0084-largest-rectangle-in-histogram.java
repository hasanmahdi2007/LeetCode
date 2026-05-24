class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> s = new ArrayDeque<>();
        int n = heights.length;
        int max_area = heights[0];
        s.push(0);
        for(int i = 1; i < n; i++){
            while(!s.isEmpty() && heights[i] < heights[s.peek()]) {
                int past = s.pop();
                int h;
                if(s.isEmpty()) h = heights[past] * i;
                else h = (i - s.peek() - 1) * heights[past];
                if(h > max_area) max_area = h;
            }
            s.push(i);    
        }
        int i = 0;
        if(!s.isEmpty())  i = n;
        while(!s.isEmpty()){
            int past = s.pop();
            int h;
            if(s.isEmpty()) h = heights[past] * i;
            else h = ( i- s.peek() - 1) * heights[past];
            if(h > max_area) max_area = h;
        }
        return max_area;
    }
}