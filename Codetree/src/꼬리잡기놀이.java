import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 처음에 자료구조를 잘못 짜서 엄청 헤맸던 문제.
// 2차원 배열의 1, 2, 3을 계속 옮겨주면서 하려고 했는데, 머리와 꼬리가 겹치는 경우가 잘 안돼서 애를 먹었다.
// 예전에 비슷한 문제에서는 Queue를 사용했던걸 보고
// index를 알 수 있으면 점수 계산하기 쉬울 것 같아 Deque 대신 ArrayList를 채택함.
public class 꼬리잡기놀이 {
    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return r == node.r && c == node.c;
        }
    }

    static class Team {
        boolean reverse;    // 방향 반대인지 표시
        ArrayList<Node> people; // 사람들 좌표. 0: 머리사람 / 마지막: 꼬리사람, 반대일 시 마지막: 머리 / 0: 꼬리

        public Team() {
            this.reverse = false;
            people = new ArrayList<>();
        }
    }

    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static Team[] teams;        // 각 팀의 정보 저장 - 반전 여부, 사람들 좌표
    static int teamCnt;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 필요한 배열 초기화
        visited = new boolean[N][N];
        teams = new Team[M+1];
        for(int i = 1; i <= M; i++) {
            teams[i] = new Team();
        }

        // 3. DFS로 각 팀마다 머리사람을 만나면 사람들 좌표를 저장해준다.
        teamCnt = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    DFS(i, j);
                    teamCnt++;
                }
            }
        }

        // 4. K 라운드까지 시뮬레이션
        answer = 0;
        for(int round = 1; round <= K; round++) {
            move();                     // 사람 이동
            ball(round - 1);      // 공 던지기 (나머지 연산 편하게 하려고 -1 함)
        }

        System.out.println(answer);
    }

    private static void DFS(int r, int c) {
        visited[r][c] = true;
        teams[teamCnt].people.add(new Node(r, c));

        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if(map[nr][nc] == 0) continue;
            if(visited[nr][nc]) continue;

            // 머리사람일 경우에는 일반 사람으로 이동
            if(map[r][c] == 1 && map[nr][nc] == 2) DFS(nr, nc);
            // 일반 사람일 경우에는 일반 사람 or 꼬리 사람으로 이동
            if(map[r][c] == 2 && map[nr][nc] <= 3) DFS(nr, nc);
        }

        // 헷갈리지 말라고 4로 통일해 줬는데 안 했어도 괜찮았을듯
        map[r][c] = 4;
    }

    private static void move() {
        for(int i = 1; i <= M; i++) {
            // 1. 꼬리 삭제
            Node last = teams[i].reverse ? teams[i].people.get(0) : teams[i].people.get(teams[i].people.size() - 1);
            visited[last.r][last.c] = false;
            teams[i].people.remove(last);

            // 2. 머리 이동
            Node first = teams[i].reverse ? teams[i].people.get(teams[i].people.size() - 1) : teams[i].people.get(0);
            int d = getDirection(first.r, first.c);
            int nr = first.r + dr[d];
            int nc = first.c + dc[d];
            visited[nr][nc] = true;
            // 반전 여부에 따라 삽입하는 위치가 달라짐
            if(teams[i].reverse) teams[i].people.add(new Node(nr, nc));
            else teams[i].people.add(0, new Node(nr, nc));
        }
    }

    private static int getDirection(int r, int c) {
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if(visited[nr][nc]) continue;
            if(map[nr][nc] != 0) return d;
        }

        return -1;
    }

    private static void ball(int round) {
        // 문제 규칙에 따라 공을 던진다.
        int d = round / N % 4;
        switch(d) {
            case 0: simulation(round % N, 0, d); break;
            case 1: simulation(N-1, round % N, d); break;
            case 2: simulation((N-1) - round % N, N - 1, d); break;
            case 3: simulation(0, (N-1) - round % N, d); break;
        }
    }

    private static void simulation(int r, int c, int d) {
        while(true) {
            // visited 배열이 true라면 사람이 있다는 뜻이므로
            // 모든 팀을 조회해서 해당 사람이 몇번쨰 위치인지 index로 확인한다.
            if(visited[r][c]) {
                for(int i = 1; i <= M; i++) {
                    int idx = teams[i].people.indexOf(new Node(r, c));
                    if(idx != -1) {
                        // 방향 반전일 때랑 아닐때랑 점수 계산 식이 다름
                        answer += teams[i].reverse ? Math.pow(teams[i].people.size() - idx, 2) : Math.pow(idx + 1, 2);
                        // 방향 반전 후 종료
                        teams[i].reverse = !teams[i].reverse;
                        return;
                    }
                }
            }

            // 범위를 벗어나거나 사람을 만날 때까지 반복
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nc < 0 || nr >= N || nc >= N) return;
            r = nr;
            c = nc;
        }
    }
}