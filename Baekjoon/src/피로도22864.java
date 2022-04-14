import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 피로도22864 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int tired = A;
        int work = B;
        for(int i = 2; i <= 24; i++) {
            if(tired > M) {
                work = 0;
                break;
            }
            else if(tired + A > M) {
                tired -= C;
                if(tired < 0) tired = 0;
            }
            else {
                tired += A;
                work += B;
            }
        }

        System.out.println(work);
    }
}
