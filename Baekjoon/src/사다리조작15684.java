import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 알고리즘 처음 시작했을 때는 재귀함수에 익숙치 않아서 DFS문제도 BFS로 풀고 그랬는데
// 이제는 DFS로 푼 다음 가지치기 해서 시간 줄이는 게 너무 재밌다.
public class 사다리조작15684 {
    static int N, M, H;
    static int[][] map;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H+1][N+1];

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 다른 사람들은 boolean으로 하던데 나는 사다리 연결이 이해가 안 돼서
            // int형에 번호를 매겨서 사다리를 구분했다.
            map[a][b] = map[a][b+1] = i;
        }

        // 놓지 않아도 되면 0 출력 후 종료
        if(ladder()) {
            System.out.println(0);
            return;
        }
        else {
            min = Integer.MAX_VALUE;
            setLines(1, 1);
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
    
    // 사다리타기 함수
    // 문제 조건과 맞으면 true, 아니면 false를 리턴함
    private static boolean ladder() {
        for(int i = 1; i <= N; i++) {
            int r = 1;
            int c = i;
            while(r <= H) {
                if(map[r][c] != 0) {
                    if(c-1 > 0 && map[r][c] == map[r][c-1]) c = c-1;
                    else if(c+1 <= N && map[r][c] == map[r][c+1]) c = c+1;
                }
                r++;
            }

            if(c != i) return false;
        }

        return true;
    }

    // DFS 1개, 2개, 3개 순으로 해야 더 빠른 걸 머리로는 알고 있었는데
    // 구현할 방법이 생각이 안 나서 일단 다 돌았다. 그래도 300ms.
    // 처음앤 매개변수 row가 없고 그냥 1부터 쭉 돌았었는데, 잘 생각해보니 조합이라 조합처럼 코드를 바꾼것.
    private static void setLines(int cnt, int row) {
        // 최소값보다 많이 가로줄을 놓거나 3개 다 놓았으면 리턴
        if(cnt >= min) return;
        if(cnt > 3) return;

        for(int i = row; i <= H; i++) {
            for(int j = 1; j < N; j++) {
                if(map[i][j] != 0) continue;
                if(map[i][j+1] != 0) continue;

                map[i][j] = map[i][j+1] = M + cnt;
                if(ladder()) min = cnt;
                setLines(cnt + 1, i);
                map[i][j] = map[i][j+1] = 0;
            }
        }
    }
}
