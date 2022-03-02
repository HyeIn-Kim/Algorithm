class NumberOfIslands200 {
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};
    int m, n;
    boolean[][] visited;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        int cnt = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    dfs(i, j, grid);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void dfs(int r, int c, char[][] grid) {
        visited[r][c] = true;

        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
            if(visited[nr][nc]) continue;
            if(grid[nr][nc] == '1') dfs(nr, nc, grid);
        }
    }
}