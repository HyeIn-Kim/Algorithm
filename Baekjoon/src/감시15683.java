import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 감시15683 {
    // CCTV 정보
    static class CCTV {
        int r;
        int c;
        int n;

        public CCTV(int r, int c, int n) {
            this.r = r;
            this.c = c;
            this.n = n;
        }
    }

    static int N, M, K, min;        // K = CCTV 개수, min = 최소 사각지대(정답)
    static int[][] map;             // 원본 배열
    static int[] selected;          // 현재 CCTV는 어느 방향으로 회전해 있는지?
    static ArrayList<CCTV> CCTVS;   // CCTV 정보 배열

    // [CCTV 번호][회전 방향][각 진행 방향]
    // 1 ~ 5의 CCTV 회전을 한땀한땀 작성함 (혜인아.. 제발!!)
    static int[][][] dr = {
            {{0}, {1}, {0}, {-1}},
            {{0, 0}, {-1, 1}},
            {{-1, 0}, {0, 1}, {1, 0}, {0, -1}},
            {{0, -1, 0}, {-1, 0, 1}, {0, 1, 0}, {1, 0, -1}},
            {{-1, 0, 1, 0}}
    };

    static int[][][] dc = {
            {{1}, {0}, {-1}, {0}},
            {{-1, 1}, {0, 0}},
            {{0, 1}, {1, 0}, {0, -1}, {-1, 0}},
            {{-1, 0, 1}, {0, 1, 0}, {1, 0, -1}, {0, -1, 0}},
            {{0, 1, 0, -1}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        CCTVS = new ArrayList<>();

        // 1. 맵을 입력받으면서 CCTV의 개수, 위치를 저장함
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(1 <= map[i][j] && map[i][j] <= 5) {
                    CCTVS.add(new CCTV(i, j, map[i][j] - 1));
                }
            }
        }

        // 2. 변수 초기화하고 첫번째 CCTV부터 DFS 시작!
        K = CCTVS.size();
        selected = new int[K];
        min = Integer.MAX_VALUE;
        dfs(0);

        if(min == Integer.MAX_VALUE) min = cntBlank(map);
        System.out.println(min);
    }

    // dfs: CCTV K개의 방향을 하나씩 회전시킴
    private static void dfs(int idx) {
        if(idx == K) {
            // 1. CCTV를 설치하기 위해 map을 복사
            int[][] copy = new int[N][M];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    copy[i][j] = map[i][j];
                }
            }

            // 2. k개의 CCTV를 설치
            for(int k = 0; k < K; k++) {
                CCTV cur = CCTVS.get(k);
                int rotate = selected[k];
                for(int d = 0; d < dr[cur.n][rotate].length; d++) {
                    int r = cur.r;
                    int c = cur.c;
                    while(true) {
                        int nr = r + dr[cur.n][rotate][d];
                        int nc = c + dc[cur.n][rotate][d];
                        if(nr < 0 || nc < 0 || nr >= N || nc >= M) break;
                        if(copy[nr][nc] == 6) break;
                        if(copy[nr][nc] == 0) copy[nr][nc] = -1;

                        r = nr;
                        c = nc;
                    }
                }
            }

            // 3. 사각지대의 개수를 센다
            int cnt = cntBlank(copy);

            min = Math.min(min, cnt);
            return;
        }

        // 현재 CCTV 종류별로 회전 가능한 곳을 전부 돌려봄
        int n = CCTVS.get(idx).n;
        for(int i = 0; i < dr[n].length; i++) {
            selected[idx] = i;
            dfs(idx + 1);
        }
    }

    // 사각지대(0)을 세주는 함수
    private static int cntBlank(int[][] map) {
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) cnt++;
            }
        }

        return cnt;
    }
}
