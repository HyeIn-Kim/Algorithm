import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행가자1976 {
    static int N, M;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parents = new int[N+1];
        for(int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        StringTokenizer st = null;
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if(value == 0) continue;

                union(i, j);
            }
        }

        boolean isRoute = true;
        st = new StringTokenizer(br.readLine());
        int value = find(Integer.parseInt(st.nextToken()));
        for(int i = 0; i < M-1; i++) {
            int city = Integer.parseInt(st.nextToken());
            if(value != parents[city]) {
                isRoute = false;
                break;
            }
        }

        System.out.println(isRoute ? "YES" : "NO");
    }

    private static int find(int n) {
        if(parents[n] == n) return n;
        else return parents[n] = find(parents[n]);
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if(pa > pb) parents[pa] = pb;
        else parents[pb] = pa;
    }
}
