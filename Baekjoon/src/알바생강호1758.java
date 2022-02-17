import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 알바생강호1758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] people = new int[N];
        for(int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(people);
        long sum = 0;
        for(int i = N-1; i >= 0; i--) {
            int tip = people[i] - ((N-1) - i);
            sum += tip > 0 ? tip : 0;
        }

        System.out.println(sum);
    }
}
