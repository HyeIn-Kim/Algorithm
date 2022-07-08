class 정수삼각형 {
    public int solution(int[][] triangle) {
        int length = triangle.length;
        int[][] DP = new int[length][length];
        DP[0][0] = triangle[0][0];
        for(int i = 1; i < length; i++) {
            for(int j = 0; j <= i; j++) {
                if(j - 1 < 0) DP[i][j] = DP[i-1][j] + triangle[i][j];
                else DP[i][j] = Math.max(DP[i-1][j-1], DP[i-1][j]) + triangle[i][j];
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < length; i++) {
            max = Math.max(DP[length-1][i], max);
        }

        return max;
    }
}