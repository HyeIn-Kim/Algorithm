import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 공기와 닿는 가장자리 치즈를 찾으려면 치즈가 아닌 바깥쪽 공기(0)부터 탐색을 진행한다.
// BFS가 더 빠를 줄 알고 BFS 연습 겸 BFS로 풀었는데, 풀이를 보니까 DFS가 더 빠름.. 흠.. 큐 때문에?
public class 치즈2636 {
    static int R, C, total;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        total = 0;
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) total++;
            }
        }

        simulation();
    }

    private static void simulation() {
        int time = 1;
        while(true) {
            visited = new boolean[R][C];
            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(0, 0));
            visited[0][0] = true;

            int melted = 0;
            while(!queue.isEmpty()) {
                Node n = queue.poll();

                for(int d = 0; d < 4; d++) {
                    int nr = n.r + dr[d];
                    int nc = n.c + dc[d];
                    if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                    if(visited[nr][nc]) continue;

                    visited[nr][nc] = true;

                    if(map[nr][nc] == 1) {
                        melted++;
                        map[nr][nc] = 0;
                    }
                    else queue.offer(new Node(nr, nc));

                }
            }

            total -= melted;
            if(total == 0) {
                System.out.println(time);
                System.out.println(melted);
                return;
            }

            time++;
        }
    }
}
