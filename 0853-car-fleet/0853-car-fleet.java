class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer,Double> m = new HashMap<>();
        for(int i = 0; i < position.length; i++){
            double time = 1.0 * (target - position[i]) / speed[i];
            m.put(position[i],time);
        }
        Arrays.sort(position);
        Deque<Integer> s = new ArrayDeque<>();
        for(int i = position.length - 1; i >= 0; i--){
            if(i == position.length-1) s.push(position[i]);
            else{
                if(m.get(position[i]) > m.get(s.peek()))
                    s.push(position[i]);  
            }
        }
        return s.size();
    }
}    