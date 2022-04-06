import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 처음에 GCD가 아니라 제일 작은 수로 돌려서 어쩐지 답이 안나오더라 했다..
public class 공약수5618 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int divisor = GCD(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        if(N == 3) divisor = GCD(divisor, Integer.parseInt(st.nextToken()));

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= divisor/2; i++) {
            if(divisor % i == 0) sb.append(i).append("\n");
        }

        sb.append(divisor).append("\n");
        System.out.println(sb);
    }

    private static int GCD(int a, int b) {
        while(b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}
