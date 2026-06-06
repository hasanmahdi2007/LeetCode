class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int ind = 0;
        ArrayList<int[]> a = new ArrayList<>();

        while(ind < intervals.length && intervals[ind][1] < newInterval[0]){
            a.add(intervals[ind++]);
        }

        while(ind < intervals.length && intervals[ind][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[ind][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[ind][1], newInterval[1]);
            ind++;
        }

        a.add(newInterval);

        while(ind < intervals.length){
            a.add(intervals[ind++]);
        }
        int[][] answer = new int[a.size()][2];
        for(int i = 0; i < a.size(); i++) answer[i] = a.get(i);
        return answer;
    }
}