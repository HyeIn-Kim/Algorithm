import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀과사다리게임16928 {
    static int N, M;
    static int[] map;
    static HashMap<Integer, Integer> edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[100];
        edges = new HashMap<>();
        for(int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            edges.put(x, y);
        }

        BFS();
        System.out.println(map[99]);
    }

    private static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            if(curr == 99) {
                return;
            }

            for(int i = 1; i <= 6; i++) {
                int next = curr + i;
                if(next >= 100) continue;

                int nextPlace = edges.getOrDefault(next, -1);
                if(nextPlace != -1) {
                    map[next] = map[curr] + 1;
                    next = nextPlace;
                }

                if(map[next] != 0) continue;
                map[next] = map[curr] + 1;
                queue.offer(next);
            }
        }
    }
}
