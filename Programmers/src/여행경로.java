import java.util.*;
class 여행경로 {
    class Node {
        String dst;
        boolean visited;

        public Node(String dst, boolean visited) {
            this.dst = dst;
            this.visited = visited;
        }
    }

    int ticketCnt;
    boolean isAnswer = false;   // 경로를 찾았는지 표시
    HashMap<String, ArrayList<Node>> adjList;  // 인접 리스트. 각 정점은 <도착공항, 방문여부> Map으로 되어 있음
    String[] answer;

    public String[] solution(String[][] tickets) {
        adjList = new HashMap<>();
        ticketCnt = tickets.length;

        // 1. 인접 리스트 생성
        for(String[] ticket : tickets) {
            ArrayList<Node> list = adjList.getOrDefault(ticket[0], new ArrayList<Node>());
            list.add(new Node(ticket[1], false));
            adjList.put(ticket[0], list);
        }

        // 2. 사전순 정렬
        for(String key : adjList.keySet()) {
            Collections.sort(adjList.get(key), (o1, o2) -> o1.dst.compareTo(o2.dst));
        }

        answer = new String[ticketCnt + 1];
        answer[0] = "ICN";
        DFS("ICN", 1);
        return answer;
    }

    private void DFS(String curr, int cnt) {
        if(isAnswer) return;
        if(cnt == ticketCnt + 1) {
            isAnswer = true;
            return;
        }

        ArrayList<Node> list = adjList.getOrDefault(curr, null);
        if(list == null) return;
        for(Node next : list) {
            if(next.visited) continue;

            next.visited = true;
            answer[cnt] = next.dst;
            DFS(next.dst, cnt + 1);

            if(isAnswer) return;
            next.visited = false;
        }
    }
}