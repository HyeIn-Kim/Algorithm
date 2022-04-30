import java.util.*;

public class 경주로건설 {
    static class Node {
        int r;
        int c;
        int d;
        int cost;

        public Node(int r, int c, int d, int cost) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.cost = cost;
        }
    }

    static int R, C;
    static int[][][] visited;
    static int[] dr = { 1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static int solution(int[][] board) {
        R = board.length;
        C = board[0].length;

        visited = new int[R][C][4];
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                for(int k = 0; k < 4; k++) {
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        BFS(board);

        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++) {
            int cost = visited[R-1][C-1][i];
            answer = Math.min(answer, cost);
        }

        return answer;
    }

    static void BFS(int[][] board) {
        Queue<Node> queue = new LinkedList<>();
        if(board[0][1] == 0) {
            queue.offer(new Node(0, 1, 1, 100));
            visited[0][1][1] = 100;
        }

        if(board[1][0] == 0) {
            queue.offer(new Node(1, 0, 0, 100));
            visited[1][0][0] = 100;
        }

        while(!queue.isEmpty()) {
            Node n = queue.poll();

            if(n.r == R-1 && n.c == C-1) {
                continue;
            }

            for(int d = 0; d < 4; d++) {
                int nr = n.r + dr[d];
                int nc = n.c + dc[d];
                // board를 벗어나면 pass
                if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                // 벽인 곳은 갈 수 없음
                if(board[nr][nc] == 1) continue;

                int nextCost = visited[n.r][n.c][n.d] + 100;
                if(n.d != d) nextCost += 500;

                if(nextCost <= visited[nr][nc][d]) {
                    visited[nr][nc][d] = nextCost;
                    queue.offer(new Node(nr, nc, d, nextCost));
                }
            }
        }
    }
}