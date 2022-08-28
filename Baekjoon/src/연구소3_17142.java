import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연구소3_17142 {
    static class Virus {
        int r;
        int c;
        int time;

        public Virus(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    static int N, M;
    static int[][] map;
    static ArrayList<Virus> viruses;
    static Virus[] selected;
    static int time, min;
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        viruses = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) viruses.add(new Virus(i, j, 0));
            }
        }

        selected = new Virus[M];
        min = Integer.MAX_VALUE;
        combination(0, 0);
        System.out.println(min);
    }

    private static boolean isBlank() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 0) return true;
            }
        }

        return false;
    }

    private static void combination(int start, int cnt) {
        if(cnt == M) {
            BFS();
            if(time < min) min = time;
            return;
        }

        for(int i = start; i < viruses.size(); i++) {
            selected[cnt] = viruses.get(i);
            combination(start + 1, cnt + 1);
        }
    }

    private static void BFS() {
        int[][] temp = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                temp[i][j] = map[i][j];
            }
        }

        Queue<Virus> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        for(int i = 0; i < M; i++) {
            queue.offer(selected[i]);
            visited[selected[i].r][selected[i].c] = true;
        }

        while(!queue.isEmpty()) {
            Virus virus = queue.poll();
            time = virus.time;
            if(virus.time >= min) return;


            for(int d = 0; d < 4; d++) {
                int nr = virus.r + dr[d];
                int nc = virus.c + dc[d];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 1) continue;

                visited[nr][nc] = true;
                queue.offer(new Virus(nr, nc, virus.time + 1));
            }
        }
    }
}
