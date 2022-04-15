import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 공주님을구해라17836 {
    static class Node {
        int r;
        int c;
        int breakable;

        public Node(int r, int c, int breakable) {
            this.r = r;
            this.c = c;
            this.breakable = breakable;
        }
    }

    static int N, M, T;
    static int[][] map;
    static boolean[][][] visited;
    static int answer = 0;
    static int[] dr = {0, 1, -1, 0};
    static int[] dc = {1, 0,0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS(0, 0);

        System.out.println(answer != -1 ? answer : "Fail");
    }

    private static void BFS(int r, int c) {
        Queue<Node> queue = new LinkedList<>();
        visited = new boolean[N][M][2];
        queue.offer(new Node(r, c, 0));
        visited[r][c][0] = true;

        while(!queue.isEmpty()) {
            if(answer > T) {
                answer = -1;
                return;
            }

            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node n = queue.poll();
                if(n.r == N-1 && n.c == M-1) {
                    return;
                }

                for(int d = 0; d < 4; d++) {
                    int nr = n.r + dr[d];
                    int nc = n.c + dc[d];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                    if (visited[nr][nc][n.breakable]) continue;
                    if (map[nr][nc] == 2) {
                        visited[nr][nc][1] = true;
                        queue.offer(new Node(nr, nc, 1));
                    } else {
                        if (n.breakable == 0 && map[nr][nc] == 1) continue;
                        visited[nr][nc][n.breakable] = true;
                        queue.offer(new Node(nr, nc, n.breakable));
                    }
                }
            }
            answer++;
        }

        answer = -1;
    }
}
