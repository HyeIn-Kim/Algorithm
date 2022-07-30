import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 점프왕쩰리small_16173 {
    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N;
    static int[][] map;
    static int[] dr = {0, 1};
    static int[] dc = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        StringTokenizer st = null;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(BFS() ? "HaruHaru" : "Hing");
    }

    private static boolean BFS() {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        queue.offer(new Node(0, 0));
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(map[node.r][node.c] == -1) return true;

            for(int d = 0; d < 2; d++) {
                int nr = node.r + (dr[d] * map[node.r][node.c]);
                int nc = node.c + (dc[d] * map[node.r][node.c]);
                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if(visited[nr][nc]) continue;

                queue.offer(new Node(nr, nc));
                visited[nr][nc] = true;
            }
        }

        return false;
    }
}
