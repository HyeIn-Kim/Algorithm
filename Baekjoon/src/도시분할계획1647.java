import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 도시분할계획1647 {
    // 마을을 두 개로 나눈다는 게 무슨 뜻이지? 하고 한참 고민했는데
    // 그래프에서 최소 신장 트리를 만들고, 간선을 하나 제거하면 트리가 2개로 쪼개진다.
    // 최소 비용이므로 가장 비용이 큰 간선을 없애주면 두 개의 마을이 된다!
    static class Edge {
        int start;
        int end;
        int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    static int N, M;
    static int[] parents;
    static Edge[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N];
        for(int i = 0; i < N; i++) {
            parents[i] = i;
        }

        edges = new Edge[M];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(start, end, cost);
        }

        Arrays.sort(edges, (o1, o2) -> o1.cost - o2.cost);

        int cnt = 0;
        int answer = 0;
        for(int i = 0; i < M; i++) {
            int a = edges[i].start;
            int b = edges[i].end;
            if(union(a, b)) {
                answer += edges[i].cost;
                cnt++;
            }

            // N개의 정점에서 간선은 항상 N-1개 생기므로
            // 간선 하나를 없애면 N - 2
            if(cnt == N - 2) break;
        }

        System.out.println(answer);
    }

    private static int find(int n) {
        if(parents[n] == n) return n;
        else return parents[n] = find(parents[n]);
    }

    private static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if(pa == pb) return false;
        else {
            parents[pa] = pb;
            return true;
        }
    }
}
