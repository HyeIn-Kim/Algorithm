import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 마법사상어와파이어스톰20058 {
    static int N, Q, size;
    static int[][] map;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int sum, max, cnt;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        size = (int)Math.pow(2, N);
        map = new int[size][size];
        for(int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int q = 1; q <= Q; q++) {
            int L = Integer.parseInt(st.nextToken());
            firestorm((int)Math.pow(2, L));
            melt();
        }

        sum = max = cnt = 0;
        visited = new boolean[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(!visited[i][j] && map[i][j] != 0) {
                    cnt = 0;
                    DFS(i, j);
                    max = Math.max(max, cnt);
                }
            }
        }

        System.out.println(sum);
        System.out.println(max);
    }

    private static void firestorm(int L) {
        int[][] temp = new int[size][size];

        for(int r = 0; r < size; r += L) {
            for(int c = 0; c < size; c += L) {
                rotate(r, c, L, temp);
            }
        }

        map = temp;
    }

    private static void rotate(int startR, int startC, int L, int[][] temp) {
        for(int r = 0; r < L; r++) {
            for(int c = 0; c < L; c++) {
                temp[startR + c][startC + L - r - 1] = map[startR + r][startC + c];
            }
        }
    }

    private static void melt() {
        int[][] next = new int[size][size];
        for(int r = 0; r < size; r++) {
            for(int c = 0; c < size; c++) {
                next[r][c] = map[r][c];
                if(map[r][c] == 0) continue;

                int ice = 0;
                for(int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if(nr < 0 || nc < 0 || nr >= size || nc >= size) continue;
                    if(map[nr][nc] != 0) ice++;
                }

                if(ice < 3) next[r][c]--;
            }
        }

        map = next;
    }

    private static void DFS(int r, int c) {
        visited[r][c] = true;
        sum += map[r][c];
        cnt++;

        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nc < 0 || nr >= size || nc >= size) continue;
            if(visited[nr][nc]) continue;
            if(map[nr][nc] == 0) continue;
            DFS(nr, nc);
        }
    }
}