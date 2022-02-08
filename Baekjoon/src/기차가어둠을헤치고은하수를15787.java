import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 사소한 실수로 생각보다 시간을 엄청 잡아먹은 문제 ㅠㅠ
// 1 ~ 20번째에 값을 담았는데 값을 0 ~ 19번째로 검사했다...
public class 기차가어둠을헤치고은하수를15787 {
    static int N, M;
    static int[] trains;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        trains = new int[N+1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            int seat = 0;

            if(command < 3) seat = Integer.parseInt(st.nextToken());

            switch(command) {
                case 1: trains[idx] |= (1 << (seat)); break;
                case 2: trains[idx] &= ~(1 << (seat)); break;
                case 3:
                    trains[idx] = trains[idx] << 1;
                    // 21승에서 -1을 하는 이유는 1000000... -> 011111이 되므로
                    // 21번째 수만 지우고 1 ~ 20번째는 그대로 유지하기 위함
                    trains[idx] &= ((1 << 21) - 1);
                    break;
                case 4:
                    // 오른쪽 시프트는 0번째 자리에 숫자가 올 수 있으므로 0번째 자리를 지워준다.
                    trains[idx] = trains[idx] >> 1;
                    trains[idx] &= ~1;
                break;
            }
        }

        int cnt = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= N; i++) {
            if(set.contains(trains[i])) continue;
            set.add(trains[i]);
            cnt++;
        }

        System.out.println(cnt);
    }
}
