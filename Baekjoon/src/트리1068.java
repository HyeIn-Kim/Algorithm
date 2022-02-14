import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 처음에는..!! 트리를 클래스로 짰었는데
// 루트가 중간에 나오면 널포인터가 떠서... 배열로 변경했다.
public class 트리1068 {

    static int[] parents;
    static boolean[] visited;
    static int N, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        parents = new int[N];
        int root = 0;
        for(int i = 0; i < N; i++) {
            parents[i] = Integer.parseInt(st.nextToken());
            if(parents[i] == -1) root = i;
        }

        // 삭제 노드는 -2로 하고
        int deleteNum = Integer.parseInt(br.readLine());
        parents[deleteNum] = -2;

        visited = new boolean[N];
        cntLeafNode(root);
        System.out.println(cnt);
    }

    private static void cntLeafNode(int node) {
        // 삭제했으면 무시
        if(parents[node] == -2) return;
        visited[node] = true;

        // 트리 노드면 쭉 돌면서 자식찾아서 DFS
        boolean isLeafNode = true;
        for(int i = 0; i < N; i++) {
            if(parents[i] == node && !visited[i]) {
                isLeafNode = false;
                cntLeafNode(i);
            }
        }

        // 리프노드일때만 카운트 추가
        if(isLeafNode) cnt++;
    }
}
