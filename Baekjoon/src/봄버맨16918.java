import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 봄버맨16918 {
    static class Bomb {
        int r;
        int c;

        public Bomb(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int R, C, N;
    static char[][] map;
    static int[][] time;
    static Queue<Bomb> queue;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        time = new int[R][C];
        queue = new LinkedList<>();
        for(int i = 0; i < R; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < C; j++) {
                map[i][j] = input[j];
                time[i][j] = map[i][j] == '.' ? 0 : 3;
            }
        }

        for(int t = 2; t <= N; t++) {
            if(t % 2 == 0) addBombs(t);
            else explosion(t);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void addBombs(int t) {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == '.') {
                    map[i][j] = 'O';
                    time[i][j] = t + 3;
                }
            }
        }
    }

    private static void explosion(int t) {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(time[i][j] == t) queue.offer(new Bomb(i, j));
            }
        }

        while(!queue.isEmpty()) {
            Bomb b = queue.poll();
            map[b.r][b.c] = '.';
            time[b.r][b.c] = 0;
            for(int d = 0; d < 4; d++) {
                int nr = b.r + dr[d];
                int nc = b.c + dc[d];
                if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if(map[nr][nc] == '.') continue;
                map[nr][nc] = '.';
                time[nr][nc] = 0;
            }
        }
    }
}
