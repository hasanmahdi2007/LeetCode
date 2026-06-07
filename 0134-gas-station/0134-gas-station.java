class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int start = -1;
        int amount = 0;
        for(int i = 0; i < gas.length; i++){
            int profit = gas[i] - cost[i];
            tank += profit;
            amount += profit;
            if(start == -1 && profit >= 0) start = i; 
            if(tank < 0) {
                start = -1;
                tank = 0;
            }    
        }
        if(amount >= 0) return start;
        else return -1;
    }
}