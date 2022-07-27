import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BucketBrigade17198 {
    static class Node {
        int r;
        int c;
        int cnt;

        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, 1, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] map = new char[10][10];
        int sr = 0;
        int sc = 0;
        for(int i = 0; i < 10; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < 10; j++) {
                if(map[i][j] == 'B') {
                    sr = i;
                    sc = j;
                }
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cnt - o2.cnt);
        boolean[][] visited = new boolean[10][10];
        pq.offer(new Node(sr, sc, 0));
        visited[sr][sc] = true;
        while(!pq.isEmpty()) {
            Node node = pq.poll();

            for(int d = 0; d < 4; d++) {
                int nr = node.r + dr[d];
                int nc = node.c + dc[d];
                if(nr < 0 || nc < 0 || nr >= 10 || nc >= 10) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == '.') {
                    pq.offer(new Node(nr, nc, node.cnt + 1));
                    visited[nr][nc] = true;
                }
                else if(map[nr][nc] == 'L') {
                    System.out.println(node.cnt);
                    return;
                }
            }
        }
    }
}
