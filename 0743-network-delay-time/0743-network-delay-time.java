class Solution {
    private class Node{
        ArrayList<Integer> links;
        ArrayList<Integer> time;
        int minTime;
        public Node(){
            links = new ArrayList<>();
            time = new ArrayList<>();
            minTime = Integer.MAX_VALUE;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        Node[] nodes = new Node[n+1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node();
        }
        for(int i = 0; i < times.length; i++){
            int[] edge = times[i];
            nodes[edge[0]].links.add(edge[1]);
            nodes[edge[0]].time.add(edge[2]);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        heap.offer(new int[] {k, 0});
        while(!heap.isEmpty()){
            int[] panel = heap.poll();
            Node node = nodes[panel[0]];
            if(panel[1] < node.minTime) node.minTime = panel[1];
            for(int i = 0; i < node.links.size(); i++){
                if(node.time.get(i) + panel[1] < nodes[node.links.get(i)].minTime) {
                    nodes[node.links.get(i)].minTime = node.time.get(i) + panel[1];
                    heap.offer(new int[] {node.links.get(i), node.time.get(i) + panel[1]});
                }    
            }
        }
        int maxTime = nodes[k].minTime;
        for (int i = 1; i <= n; i++) {
            if (nodes[i].minTime == Integer.MAX_VALUE) return -1;
            if (nodes[i].minTime > maxTime) maxTime = nodes[i].minTime;
        }
        return maxTime;
    }
}