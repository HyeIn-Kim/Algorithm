import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 낚시왕17143 {
    static class Shark {
        int s;
        int d;
        int z;

        public Shark(int s, int d, int z) {
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static int R, C, M;
    static Shark[][] map;
    static int sum;
    // 1 위 2 아래 3 오른쪽 4 왼쪽
    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Shark[R][C];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            map[r][c] = new Shark(s, d, z);
        }

        sum = 0;
        for(int fisher = 0; fisher < C; fisher++) {
            // 1. 상어 낚시
            fishing(fisher);

            // 2. 상어 이동
            move();
        }

        System.out.println(sum);
    }

    private static void fishing(int fisher) {
        for(int i = 0; i < R; i++) {
            if(map[i][fisher] != null) {
                sum += map[i][fisher].z;
                map[i][fisher] = null;
                return;
            }
        }
    }

    private static void move() {
        Shark[][] next = new Shark[R][C];
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] != null) {
                    // 상어 이동
                    Shark shark = map[i][j];
                    int r = i;
                    int c = j;
                    int s = shark.d < 3 ? shark.s % ((R-1) * 2) : shark.s % ((C-1) * 2);
                    while(s > 0) {
                        int nr = r + dr[shark.d];
                        int nc = c + dc[shark.d];
                        if(nr < 0 || nc < 0|| nr >= R || nc >= C) {
                            shark.d = shark.d % 2 == 0 ? shark.d - 1 : shark.d + 1;
                            continue;
                        }
                        s--;

                        r = nr;
                        c = nc;
                    }
                    // 이동할 칸에 상어가 있는지 확인
                    if(next[r][c] != null){
                        if(next[r][c].z < shark.z) next[r][c] = shark;
                    }
                    else next[r][c] = shark;
                }
            }
        }

        map = next;
    }
}
