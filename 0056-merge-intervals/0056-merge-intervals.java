class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> a = new ArrayList<>();
        Arrays.sort(intervals, (c,b) -> Integer.compare(c[0],b[0]));
        a.add(intervals[0]);
        int[] current = a.get(0);
        for(int i = 1; i < intervals.length; i++){
            int[] next = intervals[i];
            if(current[1] >= next[0]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                a.add(next);
                current = next;
            }
        }
        int[][] answer = new int[a.size()][2];
        for(int j = 0; j < a.size(); j++) answer[j] = a.get(j);
        return answer;
    }
}