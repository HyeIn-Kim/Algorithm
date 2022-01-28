import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 무방향인줄 알았는데 방향그래프였다...!
public class 효율적인해킹1325 {
    static int N, M;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adjList[B].add(A);
        }

        // 1부터 모든 정점을 다 돌면서, 갈 수 있는 모든 정점을 다 계산하고
        // 최대값이라면 뒤에 붙여주는 식으로 풀었다.
        // DFS로도 풀 수 있을듯한데... DFS가 더 적합한 문제인가?
        StringBuilder sb = new StringBuilder();
        int max = 0;
        for(int n = 1; n <= N; n++) {
            Queue<Integer> queue = new LinkedList<>();
            visited = new boolean[N+1];
            queue.offer(n);
            visited[n] = true;
            int cnt = 0;
            while(!queue.isEmpty()) {
                int curr = queue.poll();
                for(Integer next : adjList[curr]) {
                    if(!visited[next]) {
                        visited[next] = true;
                        cnt++;
                        queue.offer(next);
                    }
                }
            }

            if(cnt > max) {
                max = cnt;
                sb = new StringBuilder();
                sb.append(n).append(" ");
            }
            else if(cnt == max) sb.append(n).append(" ");
        }

        System.out.println(sb);
    }

}
