import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토7569 {

    static class Node {
        int r;
        int c;
        int h;

        public Node(int r, int c, int h) {
            this.r = r;
            this.c = c;
            this.h = h;
        }
    }

    static int M, N, H;
    static int[][][] map;
    static Queue<Node> queue;
    // 상자가 3차원이므로 3차원 배열 맵, 그리고 3차원 좌표를 생성해줬다.
    static int[] dr = {0, -1, 0, 1, 0, 0};
    static int[] dc = {-1, 0, 1, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        // 푸는 방법은 2차원 토마토랑 똑같다!
        map = new int[H][N][M];
        queue = new LinkedList<>();
        for(int h = 0; h < H; h++) {
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    map[h][i][j] = Integer.parseInt(st.nextToken());
                    // 토마토인 칸을 큐에 넣어주고
                    if(map[h][i][j] == 1) queue.offer(new Node(i, j, h));
                }
            }
        }

        int day = 0;
        while(!queue.isEmpty()) {
            // 큐에서 하나씩 꺼내면서
            Node n = queue.poll();

            // 주변 토마토를 익혀가면 완성!
            for(int d = 0; d < 6; d++) {
                int nr = n.r + dr[d];
                int nc = n.c + dc[d];
                int nh = n.h + dh[d];
                // 범위 벗어나면 pass
                if(nr < 0 || nc < 0 || nh < 0 || nr >= N || nc >= M || nh >= H) continue;
                // 익지 않은 칸만 익힌다 (이미 익었거나, 토마토가 없는 칸 pass)
                if(map[nh][nr][nc] != 0) continue;

                map[nh][nr][nc] = map[n.h][n.r][n.c] + 1;
                queue.offer(new Node(nr, nc, nh));
                // 날짜는 0일부터인데 토마토는 1부터 시작해서 계산하기 편하라고 1 빼줬다.
                day = map[nh][nr][nc] - 1;
            }
        }

        // 토마토 익히기가 끝나면 맵을 처음부터 돌면서
        for(int h = 0; h < H; h++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    // 아직 안 익은 칸이 있다면 -1
                    if(map[h][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        // 아니라면 현재까지의 날짜를 출력한다.
        System.out.println(day);
    }
}
