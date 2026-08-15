class Solution {
    public int snakesAndLadders(int[][] board) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int moves = 0;
        int layer = 1;
        int n = board.length;
        int[] flat = new int[n * n + 1];
        int index = 1;
        boolean leftToRight = true;
        
        for (int i = n - 1; i >= 0; i--) {
            if (leftToRight) {
                for (int j = 0; j < n; j++) {
                    flat[index++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    flat[index++] = board[i][j];
                }
            }
            leftToRight = !leftToRight;
        }
        int last = n * n;
        boolean[] visited = new boolean[last + 1];
        q.offer(1);
        while(!q.isEmpty()){
            int tile = q.poll();
            for(int i = tile+1; i <= Math.min(tile + 6, last); i++){
                if(flat[i] != -1) {
                    if(!visited[flat[i]]) {
                        q.offer(flat[i]);
                        if(flat[i] == last) return moves+1;
                        visited[flat[i]] = true;
                    }
                }
                else {
                    if(!visited[i]) {
                        q.offer(i);
                        if(i == last) return moves+1;
                        visited[i] = true;
                    }
                }
            }
            if(--layer == 0) {
                moves++;
                layer = q.size();
            }
        }
        return -1;
    }
}