import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 초심으로 돌아가서 기초중의 기초 DFS BFS 문제부터
public class DFS와BFS1260 {

    static int N, M, V;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // N = 1000, M = 10000이므로 인접리스트를 만들어 주었다!
        adjList = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 간선 정보 입력
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(to);
            adjList[to].add(from);
        }

        // 각 인접 리스트를 오름차순 정렬해준다.
        for(int i = 1; i <= N; i++) {
            Collections.sort(adjList[i]);
        }

        sb = new StringBuilder();
        visited = new boolean[N + 1];
        DFS(V);

        sb.append("\n");
        visited = new boolean[N + 1];
        BFS(V);
        System.out.println(sb);
    }

    private static void BFS(int n) {
        Queue<Integer> queue = new LinkedList<>();
        visited[n] = true;
        queue.offer(n);
        sb.append(n + " ");

        while(!queue.isEmpty()) {
            Integer v = queue.poll();

            for(Integer i : adjList[v]) {
                if(visited[i]) continue;
                visited[i] = true;
                queue.offer(i);
                sb.append(i + " ");
            }
        }
    }

    private static void DFS(int v) {
        visited[v] = true;
        sb.append(v + " ");

        for(Integer i : adjList[v]) {
            if(visited[i]) continue;
            DFS(i);
        }
    }
}
