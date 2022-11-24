import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최소 비용을 구하는 게 아니라 뛸 수 있냐? 를 판단하니까 DP 배열을 boolean으로.
// 건널 수 있는 칸만 true로 표시하고, 거기서 새로 K 이하의 에너지를 써서 건널 수 있는 돌들만 표시
// 점점 비슷한 유형의 DP 접근법이 맞고 있어서 신기하다!
public class 징검다리건너기small_22869 {
    static int N, K;
    static int[] input;
    static boolean[] DP;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        input = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        DP = new boolean[N];
        DP[0] = true;
        for(int i = 0; i < N; i++) {
            if(!DP[i]) continue;
            for(int j = i + 1; j <= N; j++) {
                if((j - i) * (1 + Math.abs(input[i] - input[j])) <= K) DP[j] = true;
            }
        }

        System.out.println(DP[N-1] ? "YES" : "NO");
    }
}
