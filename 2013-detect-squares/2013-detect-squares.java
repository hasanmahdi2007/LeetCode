class DetectSquares {
    private Map<Integer, Map<Integer, Integer>> xMap;

    public DetectSquares() {
        xMap = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        xMap.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> yMap = xMap.get(x);
        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }
    
    public int count(int[] point) {
        int qx = point[0];
        int qy = point[1];
        int totalSquares = 0;
        if (!xMap.containsKey(qx)) return 0;
        Map<Integer, Integer> verticalPartners = xMap.get(qx);
        for (int py : verticalPartners.keySet()) {
            if (py == qy) continue;
            int sideLength = Math.abs(qy - py);
            int p1Count = verticalPartners.get(py);
            int rightX = qx + sideLength;
            if (xMap.containsKey(rightX)) {
                Map<Integer, Integer> rightYMap = xMap.get(rightX);
                totalSquares += p1Count * rightYMap.getOrDefault(qy, 0) * rightYMap.getOrDefault(py, 0);
            }
            int leftX = qx - sideLength;
            if (xMap.containsKey(leftX)) {
                Map<Integer, Integer> leftYMap = xMap.get(leftX);
                totalSquares += p1Count * leftYMap.getOrDefault(qy, 0) * leftYMap.getOrDefault(py, 0);
            }
        }
        return totalSquares;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */