import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 방법 2. N이 최대 20이므로 재귀를 사용한 DP 방법
public class 호텔1106_재귀 {
    static class City {
        int cost;
        int people;

        public City(int cost, int people) {
            this.cost = cost;
            this.people = people;
        }
    }

    static int C, N;
    static City[] cities;
    static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        cities = new City[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            cities[i] = new City(cost, people);
        }

        // DP[사람 수] = 최소 비용
        DP = new int[1001];
        System.out.println(DFS(C));
    }

    // c: 남은 사람 수
    private static int DFS(int c) {
        // c가 음수라면 목표한 고객 수를 채웠으므로 탐색 필요 X. 0을 return
        if(c <= 0) return 0;

        // 이미 최소값이 들어있다면 더 탐색하지 않고 원래 값을 return
        if(DP[c] > 0) return DP[c];

        // 모든 도시를 돌아서 최소 비용을 구한 뒤 DP를 갱신, 최소값을 반환
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            int cost = DFS(c - cities[i].people) + cities[i].cost;
            min = Math.min(min, cost);
        }

        DP[c] = min;
        return min;
    }
}
