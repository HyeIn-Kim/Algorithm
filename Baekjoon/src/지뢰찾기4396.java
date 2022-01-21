import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 쉬웠는데 문제 조건을 잘못 이해해서 엄청 틀린 문제 ㅠㅠ
public class 지뢰찾기4396 {
    static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];
        for(int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            map[i] = input;
        }

        // 사용자 입력을 받으면서 지뢰가 있는지 체크
        boolean isMine = false;
        char[][] player = new char[N][N];
        for(int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < N; j++) {
                if(!isMine && input[j] == 'x' && map[i][j] == '*') {
                    isMine = true;
                }
                player[i][j] = input[j];
            }
        }

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 지뢰가 있다면, 지뢰 칸을 열어줌
                if(isMine && map[i][j] == '*') {
                    sb.append("*");
                    continue;
                }

                // 아무것도 없는 칸
                if (player[i][j] == '.') {
                    sb.append(".");
                    continue;
                }

                // 사용자가 연 칸은 8방향 지뢰를 세어줌
                int cnt = 0;
                for (int d = 0; d < 8; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                    if (map[nr][nc] == '*') cnt++;
                }
                sb.append(cnt);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
