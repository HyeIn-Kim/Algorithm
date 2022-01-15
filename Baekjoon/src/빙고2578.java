import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 한번에 다 검사해야지...!! 하다가 오래 걸린 문제.
// 아예 입력 하나 받을 때마다 전체에서 빙고수를 세는 게 더 빠르지 않았을까 싶기도 하다.
public class 빙고2578 {
    static int[][] board;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[5][5];
        StringTokenizer st = null;
        // 입력
        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                // 빙고 수 입력받고
                int n = Integer.parseInt(st.nextToken());
                // 빙고판에 체크 & 빙고 몇줄인지 세기
                check(n);
                // 3줄이 넘어가면 게임 종료
                if(cnt >= 3) {
                    System.out.println(((5 * i) + j) + 1);
                    return;
                }
            }
        }
    }

    // 만약 내가 있는 줄의 가로, 세로, (대각선 지나가는 줄일때는 대각선)가 빙고라면
    // 내가 찾기 전에 그 줄이 빙고였다: 내가 체크되지 않았으므로 빙고 X
    // 내가 빙고 체크한 후에 그줄을 또 찾는다: 똑같은 숫자는 1번만 불려서 X
    private static void cntBingo(int r, int c) {
        int cntHorizontal = 0;
        int cntVertical = 0;
        int cntUpDigonal = 0;
        int cntDownDigonal = 0;
        for(int i = 0; i < 5; i++) {
            // 가로, 세로
            if(board[r][i] == 0) cntHorizontal++;
            if(board[i][c] == 0) cntVertical++;

            // 대각선 2줄
            if(r == c && board[i][i] == 0) cntDownDigonal++;
            if(r == 5-c-1 && board[i][5-i-1] == 0) cntUpDigonal++;
        }
        if(cntHorizontal == 5) cnt++;
        if(cntVertical == 5) cnt++;
        if(cntUpDigonal == 5) cnt++;
        if(cntDownDigonal == 5) cnt++;
    }

    private static void check(int n) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(board[i][j] == n) {
                    board[i][j] = 0;
                    cntBingo(i, j);
                    return;
                }
            }
        }
    }
}
