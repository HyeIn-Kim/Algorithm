import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 네트워크연결1922_크루스칼 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N];
        for(int i = 0; i < N; i++) {
            parent[i] = i;
        }

        StringTokenizer st = null;
        int[][] edges = new int[M][3];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken()) - 1;
            edges[i][1] = Integer.parseInt(st.nextToken()) - 1;
            edges[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(edges, (o1, o2) -> o1[2] - o2[2]);
        int answer = 0;
        for(int i = 0; i < M; i++) {
            if(find(edges[i][0]) != find(edges[i][1])) {
                answer += edges[i][2];
                union(edges[i][0], edges[i][1]);
            }
        }

        System.out.println(answer);
    }

    private static int find(int n) {
        if(parent[n] == n) return n;
        else return find(parent[n]);
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if(pa > pb) parent[pa] = pb;
        else parent[pb] = pa;
    }
}
