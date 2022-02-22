import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 누적합.. 어렵다.
// 문제의 식을 풀어보면 x1(x2 + x3 + .. + xn) + x2(x3 + x4 + ... + xn) + ... + xn-1(xn)이 된다고 한다.
// x1 + x2 + ... + xn-1 + xn 의 누적합을 미리 구해놓고
// x2 + x3 + ... + xn 같은 경우 x1 + x2 + ... + xn - x1 이런식으로 접근해서 풀면 된다!!
public class 귀찮아14929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N+1];
        int[] sum = new int[N+1];
        for(int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + numbers[i];
        }

        long answer = 0;
        for(int i = 1; i <= N; i++) {
            answer += numbers[i] * (sum[N] - sum[i]);
        }

        System.out.println(answer);
    }
}
