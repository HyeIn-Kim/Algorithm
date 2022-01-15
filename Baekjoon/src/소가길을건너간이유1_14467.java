import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소가길을건너간이유1_14467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cows = new int[11];
        // -1: 소가 아직 지나가지 않음
        for(int i = 1; i <= 10; i++) {
            cows[i] = -1;
        }

        int cnt = 0;
        StringTokenizer st = null;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());
            // 소가 지나가면 지나간 방향을 표시하고
            if(cows[n] == -1) cows[n] = position;
            // 방향이 달라지면 숫자를 센다.
            else {
                if(cows[n] != position) {
                    cows[n] = position;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
