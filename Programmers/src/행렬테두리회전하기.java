import java.util.Arrays;

// dr, dc 안썼으면 30분만에 풀었을 것 같다...
class 행렬테두리회전하기 {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                map[i][j] = (i * columns) + j + 1;
            }
        }

        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            int min = map[x1][y1];

            int temp = map[x1][y1];
            int d = 0;
            int r = x1 + dr[d];
            int c = y1 + dc[d];
            int nextTemp = 0;
            while(d < 4) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr < x1 || nc < y1 || nr > x2 || nc > y2) {
                    d++;
                    continue;
                }

                nextTemp = map[r][c];
                map[r][c] = temp;
                min = Math.min(min, temp);
                temp = nextTemp;
                r = nr;
                c = nc;
            }

            map[x1][y1] = temp;
            min = Math.min(min, temp);
            answer[i] = min;
        }

        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(solution(100, 97, new int[][]{{1, 1, 100, 97}}));
//        System.out.println(Arrays.toString(solution(6, 8, new int[][]{{2, 2, 5, 3}})));
//        System.out.println(solution(3, 3, new int[][]{{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}}));
        System.out.println(Arrays.toString(solution(3, 4, new int[][]{{1,1,2,2},{1,2,2,3},{1,3,2,4},{2,3,3,4}})));
        System.out.println(Arrays.toString(solution(3, 5, new int[][]{{1,1,2,2},{2,3,3,4},{1,2,3,4},{1,1,3,4},{2,2,3,5}})));
    }
}