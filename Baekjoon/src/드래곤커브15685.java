import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 드래곤커브15685 {
    static class DragonCurve {
        int r, c;
        ArrayList<Integer> points;

        public DragonCurve(int r, int c, int d) {
            this.r = r;
            this.c = c;
            points = new ArrayList<>();
            points.add(d);
        }
    }

    static boolean[][] map;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        map = new boolean[101][101];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            map[y][x] = true;
            int nr = y + dr[d];
            int nc = x + dc[d];
            if(nr >= 0 || nc >= 0 || nr < 101 || nc < 101) map[nr][nc] = true;
            draw(new DragonCurve(y + dr[d], x + dc[d], d), g);
        }

        int cnt = 0;
        for(int i = 0; i < 101; i++) {
            for(int j = 0; j < 101; j++) {
                int check = 0;
                if(map[i][j]) check++;
                if(j+1 < 101 && map[i][j+1]) check++;
                if(i+1 < 101 && map[i+1][j]) check++;
                if(i+1 < 101 && j+1 < 101 && map[i+1][j+1]) check++;

                if(check == 4) cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static void draw(DragonCurve curve, int G) {
        for(int g = 1; g <= G; g++) {
            int r = curve.r;
            int c = curve.c;
            map[r][c] = true;

            for(int i = curve.points.size()-1; i >= 0; i--) {
                int nd = (curve.points.get(i) + 1) % 4;
                int nr = r + dr[nd];
                int nc = c + dc[nd];
                if(nr < 0 || nc < 0 || nr > 100 || nc > 100) continue;
                map[nr][nc] = true;

                curve.points.add(nd);
                r = nr;
                c = nc;
            }

            curve.r = r;
            curve.c = c;
        }
    }
}
