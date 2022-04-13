import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 에라토스테네스의체2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = 2;
        boolean[] numbers = new boolean[N+1];
        int k = 0;
        while(k < K) {
            while(numbers[P]) P++;

            for(int i = P; i <= N; i+=P) {
                if(numbers[i]) continue;

                numbers[i] = true;
                if(++k == K) {
                    System.out.println(i);
                    return;
                }
            }
        }

    }
}
