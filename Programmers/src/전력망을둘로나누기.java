// 처음에는 n이 100이라고!? 어떻게 완탐이야!? 라고 생각했는데
// n이 100이고 이진 트리여도 2^7해서 7 depth만에 돌 수 있을 거라는 생각이 들었다. 그래서 완탐인가?
public class 전력망을둘로나누기 {
    static boolean[][] adjList;
    static boolean[] visited;
    static int cnt;
    static int min;
    public static int solution(int n, int[][] wires) {
        adjList = new boolean[n + 1][n + 1];
        for(int i = 0; i < wires.length; i++) {
            adjList[wires[i][0]][wires[i][1]] = true;
            adjList[wires[i][1]][wires[i][0]] = true;
        }

        min = Integer.MAX_VALUE;

        for(int i = 0; i < wires.length; i++) {
            visited = new boolean[n + 1];
            cnt = 0;
            visited[wires[i][0]] = true;
            visited[wires[i][1]] = true;
            DFS(wires[i][0], n);

            min = Math.min(min, Math.abs(cnt - (n - cnt)));
        }

        return min;
    }

    private static void DFS(int idx, int n) {
        cnt++;
        visited[idx] = true;

        for(int i = 1; i <= n; i++) {
            if(adjList[idx][i] && !visited[i]) {
                DFS(i, n);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}));
        System.out.println(solution(4, new int[][]{{1,2},{2,3},{3,4}}));
        System.out.println(solution(7, new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}}));
    }
}