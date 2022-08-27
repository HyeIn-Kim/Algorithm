import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 톱니바퀴14891 {
    static ArrayList<Integer>[] gears;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        gears = new ArrayList[4];
        for(int i = 0; i < 4; i++) {
            gears[i] = new ArrayList<>();
        }

        for(int i = 0; i < 4; i++) {
            String input = br.readLine();
            for(int j = 0; j < 8; j++) {
                gears[i].add(input.charAt(j) - '0');
            }
        }

        int K = Integer.parseInt(br.readLine());
        for(int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());

            if(n - 1 >= 0 && gears[n-1].get(2) != gears[n].get(6)) left(n-1, direction * -1);
            if(n + 1 < 4 && gears[n+1].get(6) != gears[n].get(2)) right(n+1, direction * -1);

            spin(n, direction);
        }

        int score = 0;
        for(int i = 0; i < 4; i++) {
            score += gears[i].get(0) == 1 ? Math.pow(2, i) : 0;
        }

        System.out.println(score);
    }

    private static void left(int n, int direction) {
        if(n - 1 >= 0 && gears[n-1].get(2) != gears[n].get(6)) left(n-1, direction * -1);

        spin(n, direction);
    }

    private static void right(int n, int direction) {
        if(n + 1 < 4 && gears[n+1].get(6) != gears[n].get(2)) right(n+1, direction * -1);

        spin(n, direction);
    }

    private static void spin(int n, int direction) {
        int value = direction == 1 ? gears[n].remove(7) : gears[n].remove(0);
        if(direction == 1) gears[n].add(0, value);
        else gears[n].add(value);
    }
}
