import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AB16953 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        Queue<Long> queue = new LinkedList<>();
        queue.offer(A);

        int cnt = 0;
        int answer = -1;
        outer:
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                long temp = queue.poll();

                if(temp == B) {
                    answer = cnt + 1;
                    break outer;
                }

                if(temp * 2 <= B) queue.offer(temp * 2);
                if(temp * 10 + 1 <= B) queue.offer(temp * 10 + 1);
            }

            cnt++;
        }

        System.out.println(answer);
    }
}
