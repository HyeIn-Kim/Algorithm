import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합의표현1717 {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];
        for(int i = 0; i <= N; i++) {
            parents[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch(command) {
                case 0: union(a, b); break;
                case 1: sb.append(find(a) == find(b) ? "YES" : "NO").append("\n"); break;
            }
        }

        System.out.println(sb);
    }

    // 경로 압축한 union find
    // 압축하지 않으면 O(logN), 최악의 경우(치우친 트리라면) O(N)
    // 압축하면 O(a(N))인데, a(N)은 아커만 함수이고 x^65536제곱일 때 5가 되는 아주 느리게 증가하는 함수이다. 상수 시간으로 생각해도 좋다.
    private static int find(int a) {
        if(parents[a] == a) return a;
        else return parents[a] = find(parents[a]);
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if(pa > pb) parents[pa] = pb;
        else parents[pb] = pa;
    }
}
