import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시뮬레이션으로 하다가
// 폭탄을 한꺼번에 터트리는 게 안되길래 갈아엎고 BFS로 접근했었는데 (3번쯤 갈아엎음)
// 이번 턴에 터지는 폭탄이 아닌 것들만 지워주면 됐었다... ㅠㅠ
public class 봄버맨16918 {
    static int R, C, N;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for(int i = 0; i < R; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < C; j++) {
                map[i][j] = input[j] == 'O' ? 3 : 0;
            }
        }

        for(int t = 2; t <= N; t++) {
            if(t % 2 == 0) addBombs(t);
            else explosion(t);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                sb.append(map[i][j] == 0 ? '.' : 'O');
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void addBombs(int time) {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = time + 3;
                }
            }
        }
    }

    private static void explosion(int time) {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] == time) {
                    map[i][j] = 0;
                    for(int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                        if(map[nr][nc] != time) map[nr][nc] = 0;
                    }
                }
            }
        }
    }
}
