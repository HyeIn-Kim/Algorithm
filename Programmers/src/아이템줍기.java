import java.util.*;
public class 아이템줍기 {
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

    static final int MAX = 102;
    static int[][] map;
    static boolean[][] visited;
    static int answer;
    static int[] dr = {1, 0, 0, -1, 1, 1, -1, -1};
    static int[] dc = {0, 1, -1, 0, -1, 1, 1, -1};

    static public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        fillMap(rectangle);

        answer = 0;
        BFS(characterY * 2, characterX * 2, itemY * 2, itemX * 2);

        return answer;
    }

    private static void BFS(int sr, int sc, int er, int ec) {
        visited = new boolean[MAX][MAX];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(sr, sc, 0));
        visited[sr][sc] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            // 1. 도착점인지 검사
            if(node.r == er && node.c == ec) {
                answer = node.cnt / 2;
                return;
            }

            // 2. 바깥 테두리인지 검사
            boolean isLine = false;
            for(int d = 0; d < 8; d++) {
                int nr = node.r + dr[d];
                int nc = node.c + dc[d];
                if(nr < 0 || nc < 0 || nr >= MAX || nc >= MAX) continue;
                if(map[nr][nc] == 0) {
                    isLine = true;
                    break;
                }
            }

            if(!isLine) continue;

            for(int d = 0; d < 4; d++) {
                int nr = node.r + dr[d];
                int nc = node.c + dc[d];
                if(nr < 0 || nc < 0 || nr >= MAX || nc >= MAX) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 0) continue;

                visited[nr][nc] = true;
                queue.offer(new Node(nr, nc, node.cnt + 1));
            }
        }
    }

    private static void fillMap(int[][] rectangle) {
        map = new int[MAX][MAX];
        for(int i = 0; i < rectangle.length; i++) {
            int sc = rectangle[i][0] * 2;
            int sr = rectangle[i][1] * 2;
            int ec = rectangle[i][2] * 2;
            int er = rectangle[i][3] * 2;
            for(int j = sr; j <= er; j++) {
                for(int k = sc; k <= ec; k++) {
                    map[j][k] = 1;
                }
            }
        }
    }
}