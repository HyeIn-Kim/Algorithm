import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 저번에는 너무 어려웠었는데 문제 천천히 다시 읽고 푸니까 금방 풀렸다.
public class 연구소3_17142 {
    static class Virus {
        int r;
        int c;

        public Virus(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class Node {
        int r;
        int c;
        int time;

        public Node(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    static int N, M;
    static int[][] map;
    static ArrayList<Virus> viruses;
    static int[] selected;
    static int blanks, left;
    static int min;
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        blanks = 0;
        map = new int[N][N];
        viruses = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) blanks++;
                if(map[i][j] == 2) viruses.add(new Virus(i, j));
            }
        }

        if(blanks == 0) {
            System.out.println(0);
            return;
        }

        selected = new int[M];
        min = Integer.MAX_VALUE;
        combination(0, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    private static void combination(int start, int cnt) {
        if(cnt == M) {
            BFS();
            return;
        }

        for(int i = start; i < viruses.size(); i++) {
            selected[cnt] = i;
            combination(i + 1, cnt + 1);
        }
    }

    private static void BFS() {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        left = blanks;
        for(int i = 0; i < M; i++) {
            queue.offer(new Node(viruses.get(selected[i]).r, viruses.get(selected[i]).c, 0));
            visited[viruses.get(selected[i]).r][viruses.get(selected[i]).c] = true;
        }

        while(!queue.isEmpty()) {
            Node n = queue.poll();
            if(n.time >= min) return;

            for(int d = 0; d < 4; d++) {
                int nr = n.r + dr[d];
                int nc = n.c + dc[d];

                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 1) continue;

                visited[nr][nc] = true;
                if(map[nr][nc] == 0) left--;
                if(left == 0) {
                    min = n.time + 1;
                    return;
                }
                queue.offer(new Node(nr, nc, n.time + 1));
            }
        }
    }
}
