import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 덱을 사용한 0-1 BFS.
// 가중치가 0인 간선은 큐의 가장 앞에 삽입하고, 1인 간선은 맨 뒤에 삽입하는 방법.
// 덱을 사용하면 구현할 수 있고, 이 문제에서는 시간으로 정렬해야 했는데..
// 답을 맞추려면 *2, -1, +1 순서대로 정렬하거나 시간-위치 오름차순으로 정렬했어야 했다.
public class 숨바꼭질3_13549 {
    static class Point {
        int x;
        int time;

        public Point(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

    static int N, K;
    static int min;
    static final int MAX = 100001;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        hideAndSeek();
        System.out.println(min);
    }

    private static void hideAndSeek() {
        visited = new boolean[MAX];
        visited[N] = true;
        Deque<Point> deque = new ArrayDeque<>();
        deque.add(new Point(N, 0));

        while(!deque.isEmpty()) {
            Point p = deque.pollFirst();
            if(p.x == K) {
                min = p.time;
                return;
            }

            if(p.x * 2 < MAX && !visited[p.x * 2]) {
                deque.addFirst(new Point(p.x * 2, p.time));
                visited[p.x * 2] = true;
            }
            if(p.x - 1 >= 0 && !visited[p.x - 1]) {
                deque.addLast(new Point(p.x - 1, p.time + 1));
                visited[p.x - 1] = true;
            }
            if(p.x + 1 < MAX && !visited[p.x + 1]) {
                deque.addLast(new Point(p.x + 1, p.time + 1));
                visited[p.x + 1] = true;
            }
        }
    }
}
