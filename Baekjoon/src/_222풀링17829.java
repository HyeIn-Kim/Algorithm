import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _222풀링17829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(arr, N));
    }

    private static int getSecondGreatestNumber(int[][] arr, int startR, int startC) {
        int[] temp = new int[4];
        temp[0] = arr[startR][startC];
        temp[1] = arr[startR][startC + 1];
        temp[2] = arr[startR + 1][startC];
        temp[3] = arr[startR + 1][startC + 1];
        Arrays.sort(temp);

        return temp[2];
    }

    private static int dfs(int[][] arr, int size) {
        if(size == 2) {
            return getSecondGreatestNumber(arr, 0 , 0);
        }

        int[][] next = new int[size/2][size/2];
        for(int i = 0; i < size/2; i++) {
            for(int j = 0; j < size/2; j++) {
                next[i][j] = getSecondGreatestNumber(arr, 2 * i, 2 * j);
            }
        }

        return dfs(next, size/2);
    }
}
