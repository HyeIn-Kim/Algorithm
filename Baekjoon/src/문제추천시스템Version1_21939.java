import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1. 가장 어려운 문제, 가장 쉬운 문제를 찾는 PQ 2개
// 2. 문제 난이도를 비교하는 용도의 배열 하나
// 두 PQ에 넣으면서 배열에 현재 문제의 난이도가 몇인지 체크하고,
// PQ의 top이 뽑은 문제의 난이도가 배열에 적힌거랑 똑같다 : 시스템에 있는 문제. 그대로 출력
// 배열에 적힌거랑 다르다: 삭제됐거나 난이도가 변경된 문제. PQ에서 뽑아버림
public class 문제추천시스템Version1_21939 {
    static class Problem {
        int id;
        int level;

        public Problem(int id, int level) {
            this.id = id;
            this.level = level;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Problem> max = new PriorityQueue<>((o1, o2) -> {
            if(o1.level == o2.level) return o2.id - o1.id;
            else return o2.level - o1.level;
        });
        PriorityQueue<Problem> min = new PriorityQueue<>((o1, o2) -> {
            if(o1.level == o2.level) return o1.id - o2.id;
            else return o1.level - o2.level;
        });
        int[] levels = new int[100001];
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            max.offer(new Problem(id, level));
            min.offer(new Problem(id, level));
            levels[id] = level;
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("add")) {
                int id = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                max.offer(new Problem(id, level));
                min.offer(new Problem(id, level));
                levels[id] = level;
            }
            else if(command.equals("recommend")) {
                int direction = Integer.parseInt(st.nextToken());
                while(true) {
                    Problem top = (direction == 1) ? max.peek() : min.peek();
                    if(top.level == levels[top.id]) {
                        sb.append(top.id).append("\n");
                        break;
                    }
                    else {
                        if(direction == 1) max.poll();
                        else min.poll();
                    }
                }
            }
            else if(command.equals("solved")) {
                int id = Integer.parseInt(st.nextToken());
                levels[id] = 0;
            }
        }

        System.out.println(sb);
    }
}
