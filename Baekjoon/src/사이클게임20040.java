import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 사이클 어떻게 판단하면 좋을지 고민했는데,
// 이미 같은 집합끼리 연결하려고 하면 사이클이 있는 것이라고 한다!!
public class 사이클게임20040 {
    static int N, M;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N];
        for(int i = 0; i < N; i++) {
            parents[i] = i;
        }

        int answer = 0;
        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(union(a, b)) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }

    private static int find(int n) {
        if(parents[n] == n) return n;
        else return parents[n] = find(parents[n]);
    }

    // 그래서 union 함수를 살짝 수정해서
    // 사이클이 있으면 true, 없으면 false를 리턴하도록 했다.
    private static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pa == pb) return true;
        if(pa < pb) parents[pb] = pa;
        else parents[pa] = pb;

        return false;
    }
}
