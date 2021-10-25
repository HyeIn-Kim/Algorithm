import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DFS, BFS 둘 다 풀 수 있겠지만
// 1번 컴퓨터에서 감염되는 컴퓨터의 갯수를 세는 문제이므로 (경로를 다 돌아봐야함!)
// DFS로 해결하였음
public class 바이러스2606 {

    static int V, E;
    // N이 100까지니까 인접행렬으로 구현
    static boolean[][] adjMatrix;
    static boolean[] visited;       // DFS 방문배열
    static int cnt;                 // 총 숫자

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        adjMatrix = new boolean[V+1][V+1];

        // 인접행렬 값 입력
        for(int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjMatrix[from][to] = true;
            adjMatrix[to][from] = true;
        }

        // visited를 초기화해주고 DFS한다!
        visited = new boolean[V+1];
        DFS(1);
        System.out.println(cnt);
    }

    private static void DFS(int v) {
        // 방문체크
        visited[v] = true;

        // 모든 정점에 대해
        for(int i = 1; i <= V; i++) {
            // 인접하면서도 방문하지 않은곳을 DFS
            if(adjMatrix[v][i] && !visited[i]) {
                cnt++;  // 숫자를 세준다 (1번 컴퓨터는 세지 않으므로 안쪽에 넣어줬음)
                DFS(i);
            }
        }
    }
}
