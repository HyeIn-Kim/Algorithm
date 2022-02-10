import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 돌게임9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] DP = new String[N+1];
        DP[1] = "SK";
        for(int i = 1; i <= N; i++) {
            if(i <= N - 1) DP[i + 1] = DP[i].equals("SK") ? "CY" : "SK";
            if(i <= N - 3) DP[i + 3] = DP[i].equals("SK") ? "CY" : "SK";
        }

        System.out.println(Arrays.toString(DP));
        System.out.println(DP[N]);
    }

}
