class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] isPuddles = new boolean[m+1][n+1];
        for(int[] puddle : puddles) {
            isPuddles[puddle[0]][puddle[1]] = true;
        }

        int[][] DP = new int[m+1][n+1];
        DP[1][1] = 1;
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(i - 1 > 0 && !isPuddles[i-1][j]) DP[i][j] += DP[i-1][j] % 1000000007;
                if(j - 1 > 0 && !isPuddles[i][j-1]) DP[i][j] += DP[i][j-1] % 1000000007;

                DP[i][j] %= 1000000007;
            }
        }

        return DP[m][n];
    }
}