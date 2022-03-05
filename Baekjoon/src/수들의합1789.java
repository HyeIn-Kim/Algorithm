import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수들의합1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        int N = 1;
        while(S > 0) {
            S -= N;
            N++;
        }

        System.out.println(S < 0 ? N-2 : N-1);
    }
}
