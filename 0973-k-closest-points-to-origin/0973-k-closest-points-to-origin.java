class Solution {

    private class Node{
        public int index;
        public int distance;

        public Node(int distance, int index){
            this.index = index;
            this.distance = distance;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        int[][] answer = new int[k][2];
        PriorityQueue<Node> heap = new PriorityQueue<>(k, (a,b) -> Integer.compare(b.distance, a.distance));
        for(int i = 0; i < points.length; i++){
            int distance = distance(points[i]);
            if(heap.size() == k){
                if(distance < heap.peek().distance){
                    heap.poll();
                    heap.add(new Node(distance, i));
                }
            } else heap.add(new Node(distance, i));
        }
        for(int i = 0; i < k; i++) answer[i] = points[heap.poll().index];
        return answer;
    }

    public int distance(int[] point){
        int x = point[0];
        int y = point[1];
        return x * x + y * y;
    }
}