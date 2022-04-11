import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 서강근육맨20300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] machines = new long[N];
        for(int i = 0; i < N; i++) {
            machines[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(machines);
        long answer = 0;
        if(N % 2 == 0) {
            for(int i = 0; i <= N/2; i++) {
                answer = Math.max(answer, machines[i] + machines[N-1-i]);
            }
        }
        else {
            for(int i = 0; i <= (N-1)/2; i++) {
                answer = Math.max(answer, machines[i] + machines[N-2-i]);
            }

            answer = Math.max(answer, machines[N-1]);
        }

        System.out.println(answer);
    }
}
