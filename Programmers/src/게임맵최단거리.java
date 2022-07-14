import java.util.*;
class 게임맵최단거리 {
    class Node {
        int r;
        int c;
        int cnt;

        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    int[] dr = {1, 0, 0, -1};
    int[] dc = {0, 1, -1, 0};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 1));
        visited[0][0] = true;

        int answer = -1;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.r == n-1 && node.c == m-1) {
                answer = node.cnt;
                break;
            }

            for(int d = 0; d < 4; d++) {
                int nr = node.r + dr[d];
                int nc = node.c + dc[d];
                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if(visited[nr][nc]) continue;
                if(maps[nr][nc] == 0) continue;

                queue.offer(new Node(nr, nc, node.cnt + 1));
                visited[nr][nc] = true;
            }
        }

        return answer;
    }
}