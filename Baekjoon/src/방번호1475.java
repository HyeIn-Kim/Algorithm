import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 방번호1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[10];

        while(N > 0) {
            int number = N % 10;

            if(number == 6 || number == 9) cnt[6]++;
            else cnt[number]++;

            N /= 10;
        }

        cnt[6] = cnt[6] / 2 + (cnt[6] % 2 == 1 ? 1 : 0);
        int max = 0;
        for(int i = 0; i < 10; i++) {
            max = Math.max(max, cnt[i]);
        }

        System.out.println(max);
    }
}
