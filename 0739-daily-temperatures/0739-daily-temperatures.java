class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> s = new ArrayDeque<>();
        int[] answer = new int[temperatures.length];
        answer[answer.length-1] = 0;
        s.push(answer.length-1);
        if(temperatures.length == 1) return answer;
        for(int i = temperatures.length-2; i >= 0; i--){
            int temp = temperatures[i];
            int past = s.peek();
            if(temp < temperatures[past]) answer[i] = 1;
            else{
                s.pop();
                while(!s.isEmpty()) {
                    int now = s.peek();
                    if(temp < temperatures[now]){
                        answer[i] = now - i;
                        break;
                    }
                    else s.pop(); 
                }
                if(s.isEmpty()) answer[i] = 0;
            }
            s.push(i);
        }
        return answer;
    }
}