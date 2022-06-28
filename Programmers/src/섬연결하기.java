import java.util.*;
// 프림.. 오랜만에 푸니까 진짜 어려웠다. 모든 정점을 고려할땐 프림! 까지밖에 생각안남..
// 우선순위 큐를 사용한 O(E log V) 버전
// 탐색: 모든 정점 탐색 O(V) + 우선순위 큐를 사용해서 최소간선 찾는데에 O(log V) = O(V log V)
// 간선 추가: O(E)인데 힙에 넣을 떄 O(log V)가 되므로 O(E log V)
// 간선 E는 일반적으로 V보다 크기 때문에 O(E log V) + O(V log V) = O(E log V)라고 할 수 있다.
public class 섬연결하기 {
    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static int solution(int n, int[][] costs) {
        // 1. 계산이 편하도록 입력값을 인접 리스트로 변환해 준다.
        ArrayList<Edge>[] adjList = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 무방향 간선이니까 시작, 도착지점 다 넣어줌.
        for(int i = 0; i < costs.length; i++) {
            adjList[costs[i][0]].add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
            adjList[costs[i][1]].add(new Edge(costs[i][1], costs[i][0], costs[i][2]));
        }

        boolean[] visited = new boolean[n]; // 섬 방문 여부. 섬은 0번부터
        // 2. 간선들을 가중치가 적은 순서대로 정렬한 PQ로 프림 알고리즘을 구현할 것임
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        // 3. 첫번째 정점의 모든 간선을 PQ에 넣어주고, 방문 처리해 준다.
        for(Edge edge : adjList[costs[0][0]]) {
            pq.offer(new Edge(edge.start, edge.end, edge.weight));
        }
        visited[costs[0][0]] = true;

        int answer = 0;
        // 4. PQ를 순회하면서 방문하지 않은 정점 중 가장 가중치가 적은 간선을 골라 방문한다.
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            if(visited[e.end]) continue;

            visited[e.end] = true;
            // 5. 가장 가중치가 적은 간선은 정답에 더해줌
            answer += e.weight;
            // 6. 새로 방문한 정점의 간선들을 다시 PQ에 넣어준다.
            for(Edge edge : adjList[e.end]) {
                pq.offer(new Edge(edge.start, edge.end, edge.weight));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }
}