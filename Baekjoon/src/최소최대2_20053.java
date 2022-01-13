import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최소최대2_20053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            // 최소, 최대값을 구해서 출력하면 되는 문제.
            for(int i = 0; i < N; i++) {
                int input = Integer.parseInt(st.nextToken());
                max = Math.max(max, input);
                min = Math.min(min, input);
            }
            sb.append(min + " " + max + "\n");
        }
        System.out.println(sb);
    }
}
