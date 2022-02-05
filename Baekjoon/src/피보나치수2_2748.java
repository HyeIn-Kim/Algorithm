import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// long형 조심!!!
public class 피보나치수2_2748 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] fibonacci = new long[N+1];
        fibonacci[1] = 1;
        for(int i = 2; i <= N; i++) {
            fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
        }

        System.out.println(fibonacci[N]);
    }
}
