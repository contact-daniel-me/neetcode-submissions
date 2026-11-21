class Solution {
    private int rows, cols;
    private int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.rows = heights.length;
        this.cols = heights[0].length;
        this.heights = heights;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int c = 0; c < cols; c++){
            dfs(0, c, pacific);
        }

        for(int r = 0; r < rows; r++){
            dfs(r, 0, pacific);
        }

        for(int c = 0; c < cols; c++){
            dfs(rows - 1, c, atlantic);
        }
        for(int r = 0; r < rows; r++){
            dfs(r, cols - 1, atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int r = 0; r < rows; r++){
           for(int c = 0; c < cols; c++){
             if(pacific[r][c] && atlantic[r][c]){
                result.add(Arrays.asList(r, c));
             }
           }
        }

        return result;
    }

    private void dfs(int r, int c, boolean[][] reachable){
        if(reachable[r][c]) return;
        reachable[r][c] = true;

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && heights[nr][nc] >= heights[r][c]){
                dfs(nr, nc, reachable);
            }
        }
    }
}
