import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 일루미네이션5547 {
    static int W, H;
    static int[][] map;
    static boolean[][] visited;
    static int answer;
    static int[] dr = {-1, -1, 0, 0, 1, 1, -1, -1, 0, 0, 1, 1};
    static int[] dc = {0, 1, -1, 1, 0, 1, -1, 0, -1, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        // 외벽 탐색을 위해 바깥쪽에 패딩(?)을 넣어줌. (0,0)부터 DFS 탐색 쭉 돌면 한번에 외벽만 구할 수 있다.
        map = new int[H+2][W+2];
        for(int i = 1; i <= H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;
        visited = new boolean[H+2][W+2];
        DFS(0, 0);
        System.out.println(answer);
    }

    private static void DFS(int r, int c) {
        visited[r][c] = true;

        // 문제에서 육각형 좌표가 열 홀짝마다 다름.
        int start = (r % 2 == 1) ? 0 : 6;
        int end = (r % 2 == 1) ? 6 : 12;
        for(int d = start; d < end; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nc < 0 || nr >= H+2 || nc >= W+2) continue;
            if(visited[nr][nc]) continue;
            // 벽을 만나면 개수를 카운트해 준다.
            if(map[nr][nc] == 1) answer++;
            else DFS(nr, nc);
        }
    }
}
