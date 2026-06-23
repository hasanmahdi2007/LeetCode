class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] p = new int[edges.length + 1];
        for (int i = 0; i < p.length; i++) p[i] = i;
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int r1 = u;
            while (r1 != p[r1]) {
                p[r1] = p[p[r1]];
                r1 = p[r1];
            }
            int r2 = v;
            while (r2 != p[r2]) {
                p[r2] = p[p[r2]];
                r2 = p[r2];
            }
            if (r1 == r2) return edges[i];
            p[r1] = r2;
        }
        return new int[0];
    }
}