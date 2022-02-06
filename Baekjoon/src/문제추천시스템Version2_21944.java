import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 문제추천시스템Version2_21944 {
    static class Problem implements Comparable<Problem>{
        int P;
        int L;
        int G;

        public Problem(int p, int l, int g) {
            P = p;
            L = l;
            G = g;
        }

        @Override
        public int compareTo(Problem o) {
            if(this.L == o.L) return this.P - o.P;
            else return this.L - o.L;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        TreeMap<Integer, Problem> map = new TreeMap<>();
        TreeSet<Problem> problems = new TreeSet<>();
        TreeSet<Problem>[] groups = new TreeSet[101];
        // 1. 배열 초기화
        for(int i = 1; i <= 100; i++) {
            groups[i] = new TreeSet<>();
        }

        // 2. 문제 입력
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            map.put(P, new Problem(P, L, G));
            problems.add(new Problem(P, L, G));
            groups[G].add(new Problem(P, L, G));
        }

        // 3. 명령어 입력
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("add")) {
                int P = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                int G = Integer.parseInt(st.nextToken());
                map.put(P, new Problem(P, L, G));
                problems.add(new Problem(P, L, G));
                groups[G].add(new Problem(P, L, G));
            }
            else if(command.equals("recommend")) {
                int G = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                if(x == 1) sb.append(groups[G].last().P);
                else sb.append(groups[G].first().P);
                sb.append("\n");
            }
            else if(command.equals("recommend2")) {
                int x = Integer.parseInt(st.nextToken());
                if(x == 1) sb.append(problems.last().P);
                else sb.append(problems.first().P);
                sb.append("\n");
            }
            else if(command.equals("recommend3")) {
                int x = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());

                Problem problem = null;
                if(x == 1) problem = problems.ceiling(new Problem(0, L, 0));
                else problem = problems.floor(new Problem(0, L, 0));

                if(problem == null) sb.append("-1");
                else sb.append(problem.P);
                sb.append("\n");
            }
            else if(command.equals("solved")) {
                int P = Integer.parseInt(st.nextToken());
                Problem problem = map.get(P);
                problems.remove(new Problem(problem.P, problem.L, problem.G));
                groups[problem.G].remove(new Problem(problem.P, problem.L, problem.G));
            }
        }

        System.out.println(sb);
    }
}
