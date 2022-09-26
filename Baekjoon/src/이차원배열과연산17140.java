import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 이차원배열과연산17140 {
    static class Node {
        int n;
        int cnt;

        public Node(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }

    static int R, C, K;
    static int[][] map;
    static int maxR, maxC;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()) - 1;
        C = Integer.parseInt(st.nextToken()) - 1;
        K = Integer.parseInt(st.nextToken());

        map = new int[3][3];
        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        maxR = maxC = 3;
        if(R < maxR && C < maxC && map[R][C] == K) {
            System.out.println(0);
            return;
        }

        answer = -1;
        for(int t = 1; t <= 100; t++) {
            if(maxR >= maxC) calculateR();
            else calculateC();

            if(R < maxR && C < maxC && map[R][C] == K) {
                answer = t;
                break;
            }
        }

        System.out.println(answer);
    }

    private static void calculateR() {
        HashMap<Integer, Integer>[] numbers = new HashMap[maxR];
        int temp = maxC;
        maxC = Integer.MIN_VALUE;
        for(int i = 0; i < maxR; i++) {
            numbers[i] = new HashMap<>();
            for(int j = 0; j < temp; j++) {
                if(map[i][j] == 0) continue;
                numbers[i].put(map[i][j], numbers[i].getOrDefault(map[i][j], 0) + 1);
            }

            maxC = Math.max(maxC, numbers[i].size() * 2);
        }

        map = new int[maxR > 100 ? 100 : maxR][maxC > 100 ? 100 : maxC];
        for(int i = 0; i < maxR; i++) {
            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
                if(o1.cnt == o2.cnt) return o1.n - o2.n;
                else return o1.cnt - o2.cnt;
            });

            for(Integer n : numbers[i].keySet()) {
                pq.offer(new Node(n, numbers[i].get(n)));
            }

            int idx = 0;
            while(!pq.isEmpty() && idx < maxC) {
                Node n = pq.poll();
                map[i][idx++] = n.n;
                map[i][idx++] = n.cnt;
            }
        }
    }

    private static void calculateC() {
        HashMap<Integer, Integer>[] numbers = new HashMap[maxC];
        int temp = maxR;
        maxR = Integer.MIN_VALUE;
        for(int i = 0; i < maxC; i++) {
            numbers[i] = new HashMap<>();
            for(int j = 0; j < temp; j++) {
                if(map[j][i] == 0) continue;
                numbers[i].put(map[j][i], numbers[i].getOrDefault(map[j][i], 0) + 1);
            }

            maxR = Math.max(maxR, numbers[i].size() * 2);
        }

        map = new int[maxR > 100 ? 100 : maxR][maxC > 100 ? 100 : maxC];
        for(int i = 0; i < maxC; i++) {
            PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
                if(o1.cnt == o2.cnt) return o1.n - o2.n;
                else return o1.cnt - o2.cnt;
            });

            for(Integer n : numbers[i].keySet()) {
                pq.offer(new Node(n, numbers[i].get(n)));
            }

            int idx = 0;
            while(!pq.isEmpty() && idx < maxR) {
                Node n = pq.poll();
                map[idx++][i] = n.n;
                map[idx++][i] = n.cnt;
            }
        }
    }
}
