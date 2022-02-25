import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 출석체크20438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1. 자고 있는 사람을 체크
        boolean[] isSleep = new boolean[N+3];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
            int index = Integer.parseInt(st.nextToken());
            isSleep[index] = true;
        }

        // 2. Q회 출석 체크. 자고 있는 사람은 무시, 이미 체크된 사람(과 그 배수)도 무시
        boolean[] isChecked = new boolean[N+3];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < Q; i++) {
            int index = Integer.parseInt(st.nextToken());
            if(isChecked[index]) continue;

            for(int j = index; j <= N+2; j += index) {
                if(isSleep[j]) continue;
                isChecked[index] = true;
            }
        }

        // 3. 누적합 구하기
        int[] sum = new int[N+3];
        for(int i = 3; i <= N+2; i++) {
            sum[i] = sum[i-1] + (isChecked[i] ? 1 : 0);
        }

        // 4. 각 구간에서 체크 안된사람 찾기
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(sum[end] - sum[start-1]).append("\n");
        }

        System.out.println(sb);
    }
}
