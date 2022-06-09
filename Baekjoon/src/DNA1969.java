import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNA1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] DNA = new char[N][M];
        for(int i = 0; i < N; i++) {
            DNA[i] = br.readLine().toCharArray();
        }

        char[] answer = new char[M];
        int distance = 0;
        for(int i = 0; i < M; i++) {
            int[] cnt = new int[4];     // 0: A, 1: C, 2: G, 3: T
            int max = 0;
            for(int j = 0; j < N; j++) {
                int idx = 0;
                switch(DNA[j][i]) {
                    case 'A': idx = 0; break;
                    case 'C': idx = 1; break;
                    case 'G': idx = 2; break;
                    case 'T': idx = 3; break;
                }

                cnt[idx]++;
                max = Math.max(max, cnt[idx]);
            }

            for(int j = 0; j < 4; j++) {
                if(cnt[j] == max) {
                    char ch = ' ';
                    switch(j) {
                        case 0: ch = 'A'; break;
                        case 1: ch = 'C'; break;
                        case 2: ch = 'G'; break;
                        case 3: ch = 'T'; break;
                    }

                    answer[i] = ch;
                    distance += N - max;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            sb.append(answer[i]);
        }
        System.out.println(sb);
        System.out.println(distance);
    }
}
