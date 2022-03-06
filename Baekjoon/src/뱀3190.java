import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀3190 {
    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
       }
    }

    static int N, K, L;
    static boolean[][] apple;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        apple = new boolean[N+1][N+1];

        StringTokenizer st = null;
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            apple[r][c] = true;
        }

        L = Integer.parseInt(br.readLine());
        HashMap<Integer, String> directions = new HashMap<>();
        for(int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            directions.put(time, direction);
        }

        boolean[][] visited = new boolean[N+1][N+1];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, 1));
        visited[1][1] = true;
        int d = 1;
        int r = 1;
        int c = 1;

        int time = 1;
        while(time <= 10000) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            // 1. 벽 충돌 검사
            if(nr <= 0 || nc <= 0 || nr > N || nc > N) break;

            // 2. 몸 충돌 검사
            if(visited[nr][nc]) break;

            // 3. 머리 이동
            visited[nr][nc] = true;
            queue.offer(new Node(nr, nc));

            // 4. 사과 여부에 따른 꼬리 이동
            if(apple[nr][nc]) {
                apple[nr][nc] = false;
            }
            else {
                Node tail = queue.poll();
                visited[tail.r][tail.c] = false;
            }

            // 5. 방향 전환 검사
            String D = directions.getOrDefault(time, null);
            if(D != null) {
                if(D.equals("L")) {
                    d = (d - 1 + 4) % 4;
                }
                else if(D.equals("D")) {
                    d = (d + 1) % 4;
                }
            }

            r = nr;
            c = nc;
            time++;
        }

        System.out.println(time);
    }
}
