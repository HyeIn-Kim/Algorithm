import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 오목문제.. 예전에는 쉽게쉽게 풀었었는데 이번에는 어려웠다.
// 예전: 4방향을 하나씩 함수로 만들어서 따로따로 검사함
// 지금: dr, dc로 한꺼번에 검사함 -> 문제 조건에서 왼쪽 돌의 좌표를 검사했어야 했는데 왼쪽아래 대각선일때만 혼자 출력값이 달라서 계속 틀렸다..
public class 오목2615 {
    static int[][] board;
    static int[] dr = {0, 1, 1, 1};
    static int[] dc = {1, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        board = new int[20][20];
        for(int i = 1; i <= 19; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1; i <= 19; i++) {
            for(int j = 1; j <= 19; j++) {
                if(board[i][j] != 0)  {
                    if(check(i, j, board[i][j])) return;
                }
            }
        }

        System.out.println(0);
    }

    private static boolean check(int r, int c, int stone) {
        for(int d = 0; d < 4; d++) {
            int cnt = 0;
            // 오목 검사
            for(int i = 1; i < 5; i++) {
                int nr = r + (dr[d] * i);
                int nc = c + (dc[d] * i);
                if(nr <= 0 || nc <= 0 || nr > 19 || nc > 19) break;
                if(board[nr][nc] == stone) {
                    cnt++;
                }
            }

            // 6목 검사: -1칸, 6칸째
            if(cnt == 4) {
                boolean isFirstOK = false;
                int nr = r + (dr[d] * -1);
                int nc = c + (dc[d] * -1);
                if(nr <= 0 || nc <= 0 || nr > 19 || nc > 19) isFirstOK = true;
                else if(board[nr][nc] != stone) isFirstOK = true;

                boolean isLastOK = false;
                nr = r + (dr[d] * 5);
                nc = c + (dc[d] * 5);
                if(nr <= 0 || nc <= 0 || nr > 19 || nc > 19) isLastOK = true;
                else if(board[nr][nc] != stone) isLastOK = true;

                if(isFirstOK && isLastOK) {
                    System.out.println(board[r][c]);
                    if(d == 2) System.out.println((r + dr[d] * 4) + " " + (c + dc[d] * 4));
                    else System.out.println(r + " " + c);
                    return true;
                }
            }
        }

        return false;
    }
}
