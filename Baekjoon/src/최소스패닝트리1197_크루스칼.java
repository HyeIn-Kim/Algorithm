import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최소스패닝트리1197_크루스칼 {
    static class Edge {
        int a;
        int b;
        int cost;

        public Edge(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

    static int V, E;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V];
        for(int i = 0; i < V; i++) {
            parent[i] = i;
        }

        Edge[] edges = new Edge[E];
        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(a, b, cost);
        }

        Arrays.sort(edges, (o1, o2) -> o1.cost - o2.cost);
        int answer = 0;
        for(int i = 0; i < E; i++) {
            if(find(edges[i].a) != find(edges[i].b)) {
                union(edges[i].a, edges[i].b);
                answer += edges[i].cost;
            }
        }

        System.out.println(answer);
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if(pa > pb) parent[pa] = pb;
        else parent[pb] = pa;
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        else return find(parent[x]);
    }
}
