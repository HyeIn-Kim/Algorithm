import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 친구가 연결되어 있다~ 이런 문장을 보고 처음에는 유니온 파인드 + 인접 리스트인 그래프 문제인 줄 알았는데
// 잘 생각해 보니 유니온 파인드의 부모로 최소비용인 친구로 설정하면 인접 리스트를 안 써도 된다.
public class 친구비16562 {
    static int N, M, K;
    static int[] money;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        money = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int m = Integer.parseInt(st.nextToken());
            money[i] = m;
        }

        // Union Find 초기화
        parents = new int[N];
        for(int i = 0; i < N; i++) {
            parents[i] = i;
        }

        // 친구 관계를 입력받을 때 유니온 파인드로 합쳐준다.
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            union(a, b);
        }

        // 여기까지 하면 정답일 줄 알았는데,
        // 5 4 100
        // 1 1 1 1 1
        // 1 5
        // 2 4
        // 4 3
        // 5 4
        // 처럼 다 연결되어 있어도 유니온 파인드로 다 연결되지 않는 경우가 있다.
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        for(int i = 0; i < N; i++) {
            // 따라서 find로 한번 더 정리해주고
            int parent = find(i);
            // 이미 계산한 친구 번호는 pass
            if(set.contains(parent)) continue;
            sum += money[parent];
            set.add(parent);
        }

        System.out.println(sum <= K ? sum : "Oh no");
    }

    private static int find(int n) {
        if(parents[n] == n) return n;
        else return parents[n] = find(parents[n]);
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if(pa == pb) return;
        if(money[pa] < money[pb]) parents[pb] = pa;
        else parents[pa] = pb;
    }
}
