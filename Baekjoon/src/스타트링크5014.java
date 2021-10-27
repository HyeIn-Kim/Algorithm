import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 접근은 잘 했는데 S == G일때 처리 안해서 틀렸다..
public class 스타트링크5014 {

    static int F, S, G, U, D;
    static int[] floor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        // i층에 몇 번 갈 수 있는지 표시하는 floor 배열.
        floor = new int[F+1];
        BFS(S);

        // BFS를 돌고 G층에 가지 못하면 use the stairs,
        // 갈 수 있다면 층 -1 을 해주었다 (BFS가 1부터 시작하기 때문임)
        // 처음엔 0부터 시작해서 S == G일때는 값을 못 찾았고 틀렸다.. 맙소사.
        System.out.println((floor[G] != 0) ? floor[G] - 1 : "use the stairs");
    }

    private static void BFS(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        floor[s] = 1;

        while(!queue.isEmpty()) {
            Integer n = queue.poll();
            // G층이면 끝내고
            if(n == G) return;

            // 위로 올라갈때 F층 이하이고
            if(n + U <= F) {
                // 방문하지 않은 층만
                // BFS라서 같은 층이라도 먼저 방문한 쪽이 횟수가 더 적다.
                if(floor[n+U] == 0) {
                    // 현재층 + 1 해주고 큐에 넣는다.
                    floor[n+U] = floor[n] + 1;
                    queue.offer(n+U);
                }
            }

            // 아래도 마찬가지. 1층 이상이고 방문하지 않은 층만 큐에 넣자!
            if(0 < n - D) {
                if(floor[n-D] == 0) {
                    floor[n-D] = floor[n] + 1;
                    queue.offer(n-D);
                }
            }
        }
    }
}
