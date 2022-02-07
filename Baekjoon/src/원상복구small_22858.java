import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 처음엔 어려워 보였는데, 차근차근 종이에 적어가며 생각 정리했더니 금방 풀렸다!
public class 원상복구small_22858 {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] S = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] D = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < K; i++) {
            S = swap(S, D);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(S[i]).append(" ");
        }

        System.out.println(sb);
    }

    private static int[] swap(int[] S, int[] D) {
        int[] result = new int[N + 1];
        // 문제에 나온 규칙대로 이전 상태를 찾아줌!
        for(int i = 1; i <= N; i++) {
            result[D[i]] = S[i];
        }

        return result;
    }
}
