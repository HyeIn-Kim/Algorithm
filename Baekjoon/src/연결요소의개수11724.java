import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연결요소의개수11724 {
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
            adjList[v].add(u);
        }

        int cnt = 0;
        visited = new boolean[N+1];
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                DFS(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static void DFS(int index) {
        visited[index] = true;

        for(Integer next : adjList[index]) {
            if(!visited[next]) DFS(next);
        }
    }
}
