import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 중간에 덤벙대서 너무 어려웠던 시뮬레이션 문제...
public class 미세먼지안녕17144 {
    static int R, C, T;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] cleaner;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        int cleanerCnt = 0;
        cleaner = new int[2][2];
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 청소기의 좌표를 미리 기억해둠
                if(map[i][j] == -1) {
                    cleaner[cleanerCnt][0] = i;
                    cleaner[cleanerCnt][1] = j;
                    cleanerCnt++;
                }
            }
        }

        // T초동안 작업
        for(int t = 1; t <= T; t++) {
            spread();

            clean(0, 0, cleaner[1][0], C, true);
            clean(cleaner[1][0], 0, R, C, false);
        }

        int sum = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] > 0) sum += map[i][j];
            }
        }

        System.out.println(sum);
    }

    private static void spread() {
        // 새로운 미세먼지 상태, 기존 맵을 복사
        int[][] next = new int[R][C];
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                next[i][j] = map[i][j];
            }
        }

        // 미세먼지 이동
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(next[i][j] <= 0) continue;

                int cnt = 0;
                int dust = map[i][j] / 5;
                for(int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                    if(map[nr][nc] == -1) continue;

                    cnt++;
                    next[nr][nc] += dust;
                }

                next[i][j] -= dust * cnt;
            }
        }

        // 상태 갱신
        map = next;
    }
    
    // (sr, sc)부터 (er, ec)까지 직사각형 범위를 쭉 돈다고 생각하고 구현함
    private static void clean(int sr, int sc, int er, int ec, boolean isClockRotate) {
        int d = 0;
        int cleanerR = cleaner[isClockRotate ? 0 : 1][0];
        int cleanerC = cleaner[isClockRotate ? 0 : 1][1];
        int r = cleanerR;
        int c = cleanerC;
        
        while(d < 4) {
            // 1칸씩 땡기기 위해서 문제 방향이랑 거꾸로 구현하였음.
            // 방향으로 위쪽 청소기인지 아래쪽 청소기인지 판단 후 이동방향 조정
            int nr = r + ((d % 2 == 0 && !isClockRotate) ? -dr[d] : dr[d]);
            int nc = c + dc[d];
            
            // 청소가 끝나면 종료
            if(cleanerR == nr && cleanerC == nc) {
                map[r][c] = 0;
                break;
            }
            
            // 벽에 부딪히면 방향 전환
            if(nr < sr || nc < sc || nr >= er || nc >= ec) {
                d++;
                continue;
            }

            // 청소기가 아닌곳은 1칸씩 땡긴다.
            if(map[r][c] != -1) map[r][c] = map[nr][nc];
            r = nr;
            c = nc;
        }
    }
}
