import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 브론즈 2인데 수학 몰라서 답봤다. 분하다..
// 이 문제는 조건대로 하면 a^b의 b가 백만이므로 long으로도 구할 수 없는데
// 11에 6을 곱하든 126을 곱하든 311246을 곱하든 마지막 자릿수는 6(고정)이라는 아이디어로 푸는 문제다.
public class 분산처리1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        for(int testCase = 0; testCase < T; testCase++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 제곱수는 4주기로 반복되기 때문에
            // b를 4의 나머지로 나눠놓으면 연산속도를 무지무지 줄일 수 있다. 100만회를 4번으로.
            // +4인 이유는 나머지가 0일때를 위해서이다.
            b = b % 4 + 4;
            int answer = a;
            for(int i = 2; i <= b; i++) {
                // a제곱을 해준 뒤 10으로 나눈 나머지로 갱신해야 안 터진다.
                answer = (answer * a) % 10;
            }

            sb.append(answer == 0 ? 10 : answer).append("\n");
        }

        System.out.println(sb);
    }
}
