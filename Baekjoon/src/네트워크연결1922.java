import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 네트워크연결1922 {
    static class Node {
        int n;
        int cost;

        public Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }
    }

    static int N, M;
    static ArrayList<Node>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st = null;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            adjList[a].add(new Node(b, c));
            adjList[b].add(new Node(a, c));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        visited = new boolean[N];
        visited[0] = true;
        for(Node node : adjList[0]) {
            pq.offer(node);
        }

        int sum = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(visited[node.n]) continue;
            visited[node.n] = true;
            sum += node.cost;

            for(Node next : adjList[node.n]) {
                if(visited[next.n]) continue;

                pq.offer(next);
            }
        }

        System.out.println(sum);
    }
}
