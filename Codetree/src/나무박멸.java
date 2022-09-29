import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 나무박멸 {
    static class Node {
        int killedTrees;
        int r;
        int c;

        public Node(int killedTrees, int r, int c) {
            this.killedTrees = killedTrees;
            this.r = r;
            this.c = c;
        }
    }

    static int N, M, K, C;
    static int[][] map;
    static int[][] herbicide;
    static int[] dr = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dc = {0, 1, 0, -1, 1, -1, 1, -1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        herbicide = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int m = 0; m < M; m++) {
            // 1. 나무 성장
            grow();
            // 2. 나무 번식
            spread();
            // 3. 제초제 분사
            kill(m);
        }

        System.out.println(answer);
    }

    private static void print() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Answer: " + answer);
        System.out.println();
    }

    private static void grow() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] <= 0) continue;

                int cnt = 0;
                for(int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                    if(map[nr][nc] > 0) cnt++;
                }

                map[i][j] += cnt;
            }
        }
    }

    private static void spread() {
        int[][] next = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                next[i][j] = map[i][j];
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] <= 0) continue;

                // 1. 나무 주변 빈 칸이 몇 칸인지 세기
                int cnt = 0;
                for(int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                    if(map[nr][nc] == 0 && herbicide[nr][nc] == 0) cnt++;
                }

                // 2. 나무 주변 빈 칸에 나무를 번식한다.
                if(cnt == 0) continue;
                int tree = map[i][j] / cnt;
                for(int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                    if(i == 4 && j == 0) {
                        int a = 10;
                    }
                    if(map[nr][nc] == 0 && herbicide[nr][nc] == 0) next[nr][nc] += tree;
                }
            }
        }

        // 변경된 map 상태를 갱신
        map = next;
    }

    private static void kill(int m) {
        // 기한이 지난 제초제를 없앤다.
        removeHerbicide(m);

        // PQ에 해당 칸에서 죽일 수 있는 최대 나무 개수와 위치를 저장해서 바로 꺼낼 수 있게끔 함
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.killedTrees == o2.killedTrees) {
                if(o1.c == o2.c) return o1.r - o2.r;
                else return o1.c - o2.c;
            }
            else return o2.killedTrees - o1.killedTrees;
        });

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] > 0) {
                    pq.offer(new Node(getKilledTrees(i, j), i, j));
                }
            }
        }

        // 정답에 추가하고 제초제를 뿌린다.
        if(pq.isEmpty()) return;
        Node n = pq.poll();
        answer += n.killedTrees;
        useHerbicide(n.r, n.c, m);
    }

    private static int getKilledTrees(int r, int c) {
        int cnt = map[r][c];
        for(int d = 4; d < 8; d++) {
            for(int k = 1; k <= K; k++) {
                int nr = r + dr[d] * k;
                int nc = c + dc[d] * k;
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if(map[nr][nc] <= 0) break;
                cnt += map[nr][nc];
            }
        }

        return cnt;
    }

    private static void useHerbicide(int r, int c, int m) {
        map[r][c] = 0;
        herbicide[r][c] = m + C;

        for(int d = 4; d < 8; d++) {
            for(int k = 1; k <= K; k++) {
                int nr = r + dr[d] * k;
                int nc = c + dc[d] * k;
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if(map[nr][nc] < 0) break;
                map[nr][nc] = 0;
                herbicide[nr][nc] = m + C;
            }
        }
    }

    private static void removeHerbicide(int m) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(herbicide[i][j] == m) herbicide[i][j] = 0;
            }
        }
    }
}
