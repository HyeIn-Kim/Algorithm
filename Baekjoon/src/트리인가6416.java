import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 트리인가6416 {
    static HashMap<Integer, ArrayList<Integer>> in;         // 들어오는 간선
    static HashSet<Integer> vertices;                       // 정점
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int T = 1;         // 테스트 케이스
        vertices = new HashSet<>();
        in = new HashMap<>();
        outer: while(true) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                // (-1, -1)이 나오면 프로그램 종료
                if(u == -1 && v == -1) break outer;
                // (u, v)쌍을 계속 입력받다가 (0, 0)에서 트리 판단, TC 증가, 초기화
                if(u == 0 && v == 0) {
                    if(isTree()) {
                        sb.append("Case " + T + " is a tree.\n");
                    }
                    else sb.append("Case " + T + " is not a tree.\n");
                    T++;
                    vertices = new HashSet<>();
                    in = new HashMap<>();
                    break;
                }

                // 정점 세기
                vertices.add(u);
                vertices.add(v);

                // 들어오는 간선 추가
                ArrayList<Integer> edges = in.getOrDefault(v, new ArrayList<Integer>());
                edges.add(u);
                in.put(v, edges);
            }
        }

        System.out.println(sb);
    }

    // 원래는 입력 다 받고 DFS로 트리인지 검사하려고 했는데
    // 문제 조건 1, 2를 만족하면 3번은 자동으로 만족된다.
    private static boolean isTree() {
        // 1. 자료구조가 비어있으면 트리
        if(vertices.size() == 0) return true;
        // 2. 들어오는 간선이 없는 노드가 1개가 아니면 트리 X
        if(vertices.size() - in.size() != 1) return false;
        // 3. 루트 외 노드에서 들어오는 간선이 1개 이상이면 트리 X
        for(Integer n : in.keySet()) {
            if(in.get(n).size() > 1) return false;
        }

        return true;
    }
}
