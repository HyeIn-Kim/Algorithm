import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 충분히 풀 수 있었는데 급하게 풀다가 틀렸다.. 깝치지말자
public class 맥주마시면서걸어가기9205 {

    // 거리(r, c)를 저장할 class Node
    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N;               // 편의점의 개수 N
    static Node[] vertex;       // 좌표를 저장할 배열. 0: 시작점, N+1: 락페스티벌 좌표
    static boolean[] visited;   // DFS 방문 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            N = Integer.parseInt(br.readLine());
            // 시작점과 락페까지 넣어서 N+2이다.
            vertex = new Node[N+2];
            // 모든 좌표를 저장하고
            for(int i = 0; i < N+2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                vertex[i] = new Node(r, c);
            }

            visited = new boolean[N+2];
            // 시작점인 0부터 시작!
            DFS(0);

            // N+1은 락페스티벌 좌표. 락페에 도착했다면 happy, 못하면 sad
            sb.append(((visited[N+1]) ? "happy" : "sad") + "\n");
        }
        System.out.println(sb);
    }

    private static void DFS(int n) {
        visited[n] = true;

        for(int i = 0; i < N+2; i++) {
            int dist = Math.abs(vertex[n].r - vertex[i].r) + Math.abs(vertex[n].c - vertex[i].c);
            // 거리가 1000이 넘거나(맥주 20병 이상), 이미 간 좌표(편의점)라면 pass
            if(dist > 1000) continue;
            if(visited[i]) continue;

            DFS(i);
        }
    }
}
