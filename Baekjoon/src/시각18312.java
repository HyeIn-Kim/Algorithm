import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 시각18312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int cnt = 0;
        outer:
        for(int h1 = 0; h1 <= 2; h1++) {
            for(int h2 = 0; h2 <= 9; h2++) {
                if(h1*10 + h2 > N) break outer;

                for(int m1 = 0; m1 <= 5; m1++) {
                    for(int m2 = 0; m2 <= 9; m2++) {
                        for(int s1 = 0; s1 <= 5; s1++) {
                            for(int s2 = 0; s2 <= 9; s2++) {
                                if(h1 == K || h2 == K || m1 == K || m2 == K || s1 == K || s2 == K) cnt++;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
