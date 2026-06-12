class Solution {
    private class Node{
        ArrayList<Integer> links;
        ArrayList<Integer> cost;
        int minStops;
        public Node(){
            links = new ArrayList<>();
            cost = new ArrayList<>();
            minStops = Integer.MAX_VALUE;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer,Node> nodes = new HashMap<>();
        for(int i = 0; i < flights.length; i++){
            int[] ticket = flights[i];
            nodes.putIfAbsent(ticket[0], new Node());
            nodes.putIfAbsent(ticket[1], new Node());
            Node node = nodes.get(ticket[0]);
            node.links.add(ticket[1]);
            node.cost.add(ticket[2]);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        heap.offer(new int[] {0, 0, src});
        while(!heap.isEmpty()){
            int[] current = heap.poll();
            Node currentNode = nodes.get(current[2]);
            if(current[2] == dst){
                if(current[1] > k+1) continue;
                else return current[0];
            }
            if(currentNode == null) continue;
            int pastCost = current[0];
            if(currentNode.minStops <= current[1]) continue;
            currentNode.minStops = current[1];
            for(int i = 0; i < currentNode.links.size(); i++){
                heap.offer(new int[] {pastCost + currentNode.cost.get(i), current[1]+1, currentNode.links.get(i)});
            }
        }
        return -1;
    }
}