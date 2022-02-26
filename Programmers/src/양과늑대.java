import java.util.*;

// 문제를 봤는데 30분 넘게 이해를 못했다. 답을 봤다. 답도 이해못해서 30분 넘게 보고
// 블로그 한 2개쯤 보고 겨우 이해헸다.
class 양과늑대 {
    ArrayList<Integer>[] adjList;       // 정점 리스트
    int maxSheep = 0;                   // 최고로 모을 수 있는 양 (정답)

    public int solution(int[] info, int[][] edges) {
        adjList = new ArrayList[info.length];

        // 1. 정점 리스트 생성
        for(int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];

            if(adjList[parent] == null) adjList[parent] = new ArrayList<>();
            adjList[parent].add(child);
        }

        // 0(루트)부터 DFS 시작!
        ArrayList<Integer> next = new ArrayList<>();
        next.add(0);
        dfs(0, 0, 0, next, info);

        return maxSheep;
    }

    // cur: 현재 위치 / sheep: 현재 양 / wolf: 현재 늑대 / next: 다음에 갈 수 있는 정점들 / info: 트리 입력
    private void dfs(int cur, int sheep, int wolf, ArrayList<Integer> next, int[] info) {
        // 1. 현재 칸에서 양, 늑대 개수 갱신
        sheep += info[cur] ^ 1;     // XOR 연산으로 간편하게!
        wolf += info[cur];
        maxSheep = Math.max(maxSheep, sheep);   // 최대 양 갱신

        // 2. 만약 늑대가 같거나 많아지면 진행 불가하므로 return
        if(sheep <= wolf) return;

        // 3. 다음 노드에 인자로 주기 위해 정점 list를 복사
        ArrayList<Integer> copy = new ArrayList<>();
        for(int node : next) {
            // 현재 노드는 방문했으니까 pass
            if(node == cur) continue;
            copy.add(node);
        }

        // 4. 자식이 있으면 정점 list에 추가
        if(adjList[cur] != null) {
            for(int child : adjList[cur]) {
                copy.add(child);
            }
        }

        // 5. 다음 방문할 정점들로 DFS
        // 처음엔 copy가 아니라 next로 돌아서 무한방문함^^.. ..
        for(int nextNode : copy) {
            dfs(nextNode, sheep, wolf, copy, info);
        }
    }
}