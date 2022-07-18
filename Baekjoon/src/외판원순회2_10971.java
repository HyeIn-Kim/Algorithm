import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 외판원순회2_10971 {
    static int N;
    static int[][] map;
    static int min;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        StringTokenizer st = null;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++) {
            visited = new boolean[N];
            DFS(i, i, 0, 0);
        }

        System.out.println(min);
    }

    private static void DFS(int idx, int start, int cnt, int sum) {
        if(sum >= min) return;
        if(cnt == N - 1) {
            if(map[idx][start] != 0) min = Math.min(min, sum + map[idx][start]);
            return;
        }

        visited[idx] = true;

        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            if(map[idx][i] == 0) continue;

            DFS(i, start, cnt + 1, sum + map[idx][i]);
        }

        visited[idx] = false;
    }
}
