class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> coordinates = new ArrayList<>();
        int[][] mark = new int[m][n];
        for(int c = 0; c < n; c++) 
            pacificFlow(heights, 0, c, mark, heights[0][c]);
        for(int r = 0; r < m; r++)
            pacificFlow(heights, r, 0, mark, heights[r][0]);
        for(int c = 0; c < n; c++) 
            atlanticFlow(heights, m-1, c, mark, coordinates, heights[m-1][c]);
        for(int r = 0; r < m; r++)
            atlanticFlow(heights, r, n-1, mark, coordinates, heights[r][n-1]);
        return coordinates; 
    }

    public void pacificFlow(int[][] heights, int i, int j, int[][] mark, int lastnum){
        if(i == -1 || j == -1 || i == heights.length || j == heights[0].length) return;
        if(lastnum > heights[i][j] || mark[i][j] == 1) return;
        mark[i][j] = 1;
        pacificFlow(heights, i-1, j, mark, heights[i][j]);
        pacificFlow(heights, i+1, j, mark, heights[i][j]);
        pacificFlow(heights, i, j-1, mark, heights[i][j]);
        pacificFlow(heights, i, j+1, mark, heights[i][j]);
    }

    public void atlanticFlow(int[][] heights, int i, int j, int[][] mark, List<List<Integer>> coordinates, int lastnum){
        if(i == -1 || j == -1 || i == heights.length || j == heights[0].length) return;
        if(lastnum > heights[i][j] || mark[i][j] == 2 || mark[i][j] == 3) return;
        if(mark[i][j] == 1) {
            List<Integer> l = new ArrayList<>();
            l.add(i);
            l.add(j);
            coordinates.add(l);
            mark[i][j] = 3;
        } else mark[i][j] = 2;
        atlanticFlow(heights, i-1, j, mark, coordinates, heights[i][j]);
        atlanticFlow(heights, i+1, j, mark, coordinates, heights[i][j]);
        atlanticFlow(heights, i, j-1, mark, coordinates, heights[i][j]);
        atlanticFlow(heights, i, j+1, mark, coordinates, heights[i][j]);
    }
}