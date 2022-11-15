import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 겹치는건싫어20922 {
    static int N, K;
    static final int MAX = 100001;
    static int[] input;
    static int[] cnt;

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

        cnt = new int[MAX];
        int start = 0, end = 0;
        int max = 0;
        cnt[input[0]] = 1;
        int LSI = 1;
        while(end < N - 1) {
            if(max <= K) {
                LSI = Math.max(LSI, end - start + 1);
                end++;
                cnt[input[end]]++;
                max = Math.max(max, cnt[input[end]]);
            }
            else {
                if(max == cnt[input[start]]) max--;
                cnt[input[start]]--;
                start++;
            }
        }

        if(max <= K) LSI = Math.max(LSI, end - start + 1);
        System.out.println(LSI);
    }
}
