import java.util.HashSet;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set s = new HashSet<Integer>();
        for(int i : nums){
            if(s.contains(i)) return true;
            s.add(i);
        }
        return false;
    }
}