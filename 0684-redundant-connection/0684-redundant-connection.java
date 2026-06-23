class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int r1 = u;
            while (map.containsKey(r1) && map.get(r1) != r1) {
                r1 = map.get(r1);
            }
            int r2 = v;
            while (map.containsKey(r2) && map.get(r2) != r2) {
                r2 = map.get(r2);
            }
            if (!map.containsKey(r1)) map.put(r1, r1);
            if (!map.containsKey(r2)) map.put(r2, r2);
            if (r1 == r2) return edges[i];
            map.put(r1, r2);
        }
        return new int[0];
    }
}