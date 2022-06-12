import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운최단거리14940 {
    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M;
    static int[][] map;
    static int[][] result;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        int sr = 0;
        int sc = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    sr = i;
                    sc = j;
                }
            }
        }

        BFS(sr, sc);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(!visited[i][j] && map[i][j] == 1  ? -1 : result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void BFS(int r, int c) {
        result = new int[N][M];
        visited = new boolean[N][M];
        Queue<Node> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.offer(new Node(r, c));

        int distance = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node n = queue.poll();
                result[n.r][n.c] = distance;

                for(int d = 0; d < 4; d++) {
                    int nr = n.r + dr[d];
                    int nc = n.c + dc[d];
                    if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                    if(visited[nr][nc]) continue;
                    if(map[nr][nc] == 0) continue;

                    visited[nr][nc] = true;
                    queue.offer(new Node(nr, nc));
                }
            }

            distance++;
        }
    }
}
