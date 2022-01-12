import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

// 거리 공식 나오고 문제가 좀 무서운데
// 원의 시작점, 끝점(x-r, x+r)을 괄호 쌍처럼 치환해서 풀면 쉽다.
public class 데이터체커22942 {
    static class Circle {
        int x;                  // 현재 점 위치
        int n;                  // 원 번호

        public Circle(int x, int n) {
            this.x = x;
            this.n = n;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 원마다 번호를 매겨서 시작점(x-r), 끝점(x+r)을 오름차순으로 정렬한다.
        PriorityQueue<Circle> pq = new PriorityQueue<>((o1, o2) -> o1.x - o2.x);
        StringTokenizer st = null;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            pq.add(new Circle(x-r, i));
            pq.add(new Circle(x+r, i));
        }

        // 입력값을 스택에 넣으면서
        Stack<Circle> stack = new Stack<>();
        while(!pq.isEmpty()) {
            Circle c = pq.poll();
            if(stack.isEmpty()) stack.push(c);
            else {
                // top의 번호가 내 번호랑 같을때는 같은 원이므로 교점 없음. pop
                if(stack.peek().n == c.n) stack.pop();
                // 다를 때는 push를 해준다.
                else stack.push(c);
            }
        }

        // while문이 끝났을 때, 교점이 있다면 stack에는 값이 남고
        // 교점이 없으면 stack이 비어 있음.
        System.out.println(stack.isEmpty() ? "YES" : "NO");
    }
}
