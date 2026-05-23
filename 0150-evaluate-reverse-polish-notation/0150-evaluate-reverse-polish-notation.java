class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> s = new ArrayDeque<>();
        for(int i = 0; i < tokens.length; i++){
            String temp = tokens[i];
            if(temp.equals("+")){
                int second = s.pop();
                int first = s.pop();
                s.push(first + second);
            } else if (temp.equals("-")){
                int second = s.pop();
                int first = s.pop();
                s.push(first - second);
            } else if (temp.equals("*")){
                int second = s.pop();
                int first = s.pop();
                s.push(first * second);
            } else if (temp.equals("/")){
                int second = s.pop();
                int first = s.pop();
                s.push(first / second);
            } 
            else s.push(Integer.parseInt(temp));
        }
        return s.peek();  
    }
}