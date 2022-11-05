import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// DP를 푼 지 오래돼서 감을 다 잃어버렸다.
// 이 문제는 선택하느냐, 선택하지 않느냐를 따지는 배낭 문제 계열이라고 한다.
public class 호텔1106 {
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
        // C + 100인 이유: 적어도 C명 이상이므로 C명이 넘었을 경우도 대비하기 위함
        DP = new int[C + 100];
        for(int i = 1; i < C + 100; i++) {
            // 최소값이라 MAX VALUE로 초기화
            DP[i] = Integer.MAX_VALUE;
        }

        // 모든 도시에 대해서
        for(int i = 0; i < N; i++) {
            for(int j = cities[i].people; j < C + 100; j++) {
                // MAX VALUE에 값을 더하면 int 터져서 예외처리 해 준 것
                if(DP[j - cities[i].people] == Integer.MAX_VALUE) continue;

                // DP[j]: 현재 도시를 선택하지 않음
                // DP[j - cities[i].people] + cities[i].cost: 현재 도시를 선택함
                DP[j] = Math.min(DP[j], DP[j - cities[i].people] + cities[i].cost);
            }
        }

        // C부터 최소값을 찾아서 출력하면 정답
        int min = DP[C];
        for(int i = C + 1; i < C + 100; i++) {
            min = Math.min(min, DP[i]);
        }

        System.out.println(min);
    }
}
