import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 인구이동16234 {
    static class Union {
        int cnt;
        int people;

        public Union(int cnt, int people) {
            this.cnt = cnt;
            this.people = people;
        }
    }

    static int N, L, R;
    static int[][] arr;
    static int[][] opened;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int cnt, people;
    static HashMap<Integer, Union> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 1. 입력
        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while(true) {
            // 2. 국경을 열 구역을 정하기
            // DFS로 인구가 이동할 수 있는 구역을 모두 찾고
            // 구역마다 번호 / 구역 수 / 전체 인구수를 저장해둔다.
            // 국경을 한번 쭉 조사할 때마다 숫자를 바꾸는 법도 생각해 봤는데
            // 바꾸고 나서 다시 조사하면 문제가 있을까 싶어서 먼저 구역을 다 분리하기로 함
            int idx = 0;
            map = new HashMap<>();
            opened = new int[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(opened[i][j] == 0) {
                        idx++;
                        cnt = people = 0;
                        openBorder(i, j, idx);
                        map.put(idx, new Union(cnt, people));
                    }
                }
            }

            // 국경이 열리지 않았다면 구역은 총 N * N개. 종료
            if(idx == N * N) break;

            // 3. 연 국경들을 쭉 돌면서 아까 구했던 인구수로 채운다.
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(opened[i][j] != 0 && !visited[i][j]) {
                        Union union = map.get(opened[i][j]);
                        int nextPeople = union.people / union.cnt;
                        cntPeople(i, j, nextPeople);
                    }
                }
            }

            day++;
        }

        System.out.println(day);
    }

    private static void openBorder(int r, int c, int idx) {
        opened[r][c] = idx;
        cnt++;
        people += arr[r][c];

        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if(opened[nr][nc] != 0) continue;

            int diff = Math.abs(arr[r][c] - arr[nr][nc]);
            if(L <= diff && diff <= R) openBorder(nr, nc, idx);
        }
    }

    private static void cntPeople(int r, int c, int nextPeople) {
        visited[r][c] = true;
        arr[r][c] = nextPeople;

        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if(visited[nr][nc]) continue;

            if(opened[r][c] == opened[nr][nc]) cntPeople(nr, nc, nextPeople);
        }
    }
}
