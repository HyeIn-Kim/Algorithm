import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 전구21918 {

    static int N, M;
    static int[] bulbs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 계산 편하게 하기 위해 N+1으로 배열을 만들고 1 ~ N에 전구를 담았다.
        bulbs = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            bulbs[i] = Integer.parseInt(st.nextToken());
        }

        // 명령어대로 전구를 켠다.
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            switch(a) {
                case 1: func1(b, c); break;
                case 2: func2(b, c); break;
                case 3: func3(b, c); break;
                case 4: func4(b, c); break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(bulbs[i] + " ");
        }

        System.out.println(sb);
    }

    private static void func1(int i, int x) {
        bulbs[i] = x;
    }

    private static void func2(int l, int r) {
        for(int i = l; i <= r; i++) {
            bulbs[i] = 1 - bulbs[i];
        }
    }

    private static void func3(int l, int r) {
        for(int i = l; i <= r; i++) {
            if(bulbs[i] == 1) bulbs[i] = 0;
        }
    }

    private static void func4(int l, int r) {
        for(int i = l; i <= r; i++) {
            if(bulbs[i] == 0) bulbs[i] = 1;
        }
    }
}
