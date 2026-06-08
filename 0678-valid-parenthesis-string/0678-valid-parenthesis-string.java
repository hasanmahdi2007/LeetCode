class Solution {
    public boolean checkValidString(String s) {
        int stars = 0;
        ArrayList<Integer> stars_arr = new ArrayList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ')'){
                if(stack.isEmpty()){
                    if(stars != 0) {
                        stars--;
                        stars_arr.remove(stars_arr.size()-1);
                    }    
                    else return false;
                } 
                else stack.pop();
            }
            else if (c == '('){
                stack.push(i);
            } else {
                stars++;
                stars_arr.add(i);
            }    
                
        }
        while(stars_arr.size() > 0 && !stack.isEmpty()) {
            int ind = stack.peek();
            if(ind < stars_arr.get(stars_arr.size()-1)) {
                stack.pop();
                stars_arr.remove(stars_arr.size()-1);
            }
            else break;
        }    
        return stack.isEmpty();
    }
}