import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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

        Arrays.sort(cities, (o1, o2) -> o1.cost - o2.cost);

        DP = new int[C + 100];
        for(int i = 1; i < C + 100; i++) {
            DP[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < N; i++) {
            for(int j = cities[i].people; j < C + 100; j++) {
                if(DP[j - cities[i].people] == Integer.MAX_VALUE) continue;
                DP[j] = Math.min(DP[j], DP[j - cities[i].people] + cities[i].cost);
            }
        }

        int min = DP[C];
        for(int i = C + 1; i < C + 100; i++) {
            min = Math.min(min, DP[i]);
        }

        System.out.println(min);
    }
}
