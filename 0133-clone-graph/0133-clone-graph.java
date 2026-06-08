/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> m = new HashMap<>();
        Node newNode = new Node(node.val);
        m.put(node, newNode);
        nodeConnector(newNode, node, m);
        return newNode;
    }

    public void nodeConnector(Node newNode, Node oldNode, HashMap<Node, Node> m) {   
        for(int i = 0; i < oldNode.neighbors.size(); i++){
            Node neighbor = oldNode.neighbors.get(i);
            Node newNeighbor = null;
            if(!m.containsKey(neighbor)) {
                newNeighbor = new Node(neighbor.val);
                m.put(neighbor, newNeighbor);
                newNode.neighbors.add(newNeighbor);
                nodeConnector(newNeighbor, neighbor, m);
            }    
            else {
                newNeighbor = m.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }
    }
}