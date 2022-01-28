import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 효율적인해킹1325 {
    static int N, M;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static PriorityQueue<Integer> temp, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adjList[A].add(B);
            adjList[B].add(A);
        }

        result = new PriorityQueue<>();
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                temp = new PriorityQueue<>();
                DFS(i);
            }
            if(temp.size() > result.size()) {
                result = temp;
            }
        }

        if(temp.size() > result.size()) {
            result = temp;
        }

        StringBuilder sb = new StringBuilder();
        while(result.isEmpty()) {
            sb.append(result.poll()).append(" ");
        }
        System.out.println(sb);
    }

    private static void DFS(int n) {
        visited[n] = true;
        for(Integer i : adjList[n]) {
            if(!visited[i]) {
                temp.offer(i);
                DFS(i);
            }
        }
    }
}
