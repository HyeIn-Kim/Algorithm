import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주사위굴리기14499 {
    static int N, M, K;
    static int[][] map;
    static int[] command;

    static int[] dice;
    static int west, east;
    static int top;

    static int[] dr = {0, 0, 0, -1, 1};
    static int[] dc = {0, 1, -1, 0, 0};
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        command = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
            command[i] = Integer.parseInt(st.nextToken());
        }

        sb = new StringBuilder();
        simulation(r, c);
        System.out.println(sb);
    }

    private static void simulation(int r, int c) {
        // 0. 주사위 초기화
        dice = new int[4];
        west = east = 0;
        top = 1;    // 주사위 top은 1번

        for(int i = 0; i < K; i++) {
            // 1. 주사위 이동
            int nr = r + dr[command[i]];
            int nc = c + dc[command[i]];

            // 2. 맵에서 벗어나는 경우 무시
            if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

            // 3. 주사위 굴림
            rollDice(command[i]);

            System.out.println(Arrays.toString(dice) + " " + west + " " + east);

            // 4. 주사위 top을 출력
            sb.append(dice[top]).append("\n");

            // 5. 주사위 바닥 처리
            int bottom = (top + 2) % 4;
            if(map[nr][nc] == 0) {
                map[nr][nc] = dice[bottom];
            }
            else {
                dice[bottom] = map[nr][nc];
                map[nr][nc] = 0;
            }

            // 6. 이동
            r = nr;
            c = nc;
        }
    }

    private static void rollDice(int direction) {
        switch(direction) {
            case 1: {
                int temp = dice[1];
                dice[1] = west;
                west = dice[3];
                dice[3] = east;
                east = temp;
                top = 1;
                break;
            }
            case 2: {
                int temp = dice[1];
                dice[1] = east;
                east = dice[3];
                dice[3] = west;
                west = temp;
                top = 1;
                break;
            }
            case 3: top = (top + 1) % 4; break;
            case 4: top = (top + 4 - 1) % 4; break;
        }
    }
}
