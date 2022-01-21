import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 달팽이1913 {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int number = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        int r = 0, c = 0, ar = 0, ac = 0;
        int cnt = N * N;
        arr[r][c] = cnt--;
        int d = 0;
        while(cnt != 0) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            boolean flag = false;
            // 배열을 벗어나거나, 숫자를 만나면 끝까지 왔음
            if(nr < 0 || nc < 0 || nr >= N || nc >= N) flag = true;
            else if(arr[nr][nc] != 0) flag = true;
            // 끝을 마주치면 방향전환
            if(flag) {
                d = (d + 1) % 4;
                continue;
            }

            // 만약 찾는 숫자면 좌표를 기억한 뒤
            if(cnt == number) {
                ar = nr;
                ac = nc;
            }
            // 숫자 적고 다음 칸으로 전진전진
            arr[nr][nc] = cnt--;
            r = nr;
            c = nc;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                // 너무 충격적인 사실
                // 지금까지 맨날
                // sb.append(arr[i][j] + " "); 썼는데
                // 메모리 차이가 너무 많이나서 보니까 이게 훨씬 빨랐음;;;;;;;;;;;;;
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append((ar + 1) + " " + (ac + 1));
        System.out.println(sb);
    }
}
