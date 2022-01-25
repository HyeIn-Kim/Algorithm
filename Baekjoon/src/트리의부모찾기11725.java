import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의부모찾기11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] adjList = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for(int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adjList[start].add(end);
            adjList[end].add(start);
        }

        // 방문배열도 만들어줄까 생각했었는데
        // 부모를 이미 찾았으면 방문한 노드이니 방문하지 않아도 되겠다 싶어 부모 배열만 만들었음
        int[] parents = new int[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        parents[1] = -1;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            // 인접한 노드 중 이미 방문했다면 pass
            for(Integer next : adjList[node]) {
                if(parents[next] == 0) {
                    queue.offer(next);
                    parents[next] = node;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= N; i++) {
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb);
    }
}
