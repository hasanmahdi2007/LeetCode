class Solution {
    private class Node{
        PriorityQueue<String> links;
        public Node(){
            links = new PriorityQueue<>();
        }
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, Node> map = new HashMap<>();
        for(int i = 0; i < tickets.size(); i++){
            List<String> ticket = tickets.get(i);
            if(!map.containsKey(ticket.get(0))) {
                Node node1 = new Node();
                map.put(ticket.get(0), node1);
            }    
            if(!map.containsKey(ticket.get(1))) {
                Node node2 = new Node();
                map.put(ticket.get(1), node2);
            }
            map.get(ticket.get(0)).links.offer(ticket.get(1));
        }       
        ArrayDeque<String> q = new ArrayDeque<>();
        Hierholzer("JFK", q, map);
        List<String> L = new ArrayList<>(q);
        return L;
    }

    public void Hierholzer(String current, ArrayDeque<String> q, HashMap<String, Node> map){
        Node currentNode = map.get(current);
        while(!currentNode.links.isEmpty()){
           String next = currentNode.links.poll();
           Hierholzer(next, q, map);
        }
        q.addFirst(current);
    }
}