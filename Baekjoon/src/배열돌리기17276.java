import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열돌리기17276 {
    static int N, angle;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            angle = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 시계방향, 반시계방향 함수를 2개 만들어 놓은 다음
            // 각도 % 360 (360도를 돌면 제자리이므로 360으로 나눈 나머지만 배열을 돌리게됨)
            // 방향에 따라 맞는 함수를 적용하면서 배열을 돌린다!
            if(angle > 0) {
                for(angle %= 360; angle > 0; angle -= 45) {
                    arr = rotateClock();
                }
            }
            else {
                for(angle %= 360; angle < 0; angle += 45) {
                    arr = rotateClockReverse();
                }
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    private static int[][] rotateClock() {
        int[][] result = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                result[i][j] = arr[i][j];
            }
        }

        for(int i = 0; i < N; i++) {
            result[i][N/2] = arr[i][i];
            result[i][(N-1) - i] = arr[i][N/2];
            result[N/2][i] = arr[(N-1) - i][i];
            result[(N-1) - i][(N-1) - i] = arr[N/2][(N-1) - i];
        }

        return result;
    }

    private static int[][] rotateClockReverse() {
        int[][] result = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                result[i][j] = arr[i][j];
            }
        }

        for(int i = 0; i < N; i++) {
            result[N/2][i] = arr[i][i];
            result[(N-1) - i][i] = arr[N/2][i];
            result[(N-1) - i][N/2] = arr[(N-1) - i][i];
            result[(N-1) - i][(N-1) - i] = arr[(N-1) - i][N/2];
        }

        return result;
    }
}
