import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소스패닝트리1197 {
    static class Node {
        int n;
        int cost;

        public Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }
    }

    static int V, E;
    static ArrayList<Node>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            adjList[i] = new ArrayList();
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            int C = Integer.parseInt(st.nextToken());

            adjList[A].add(new Node(B, C));
            adjList[B].add(new Node(A, C));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        visited = new boolean[V];
        visited[0] = true;
        for(Node node : adjList[0]) {
            pq.offer(new Node(node.n, node.cost));
        }

        int sum = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();

            if(visited[node.n]) continue;
            visited[node.n] = true;
            sum += node.cost;

            for(Node next : adjList[node.n]) {
                if(visited[next.n]) continue;
                pq.offer(new Node(next.n, next.cost));
            }
        }

        System.out.println(sum);
    }
}
