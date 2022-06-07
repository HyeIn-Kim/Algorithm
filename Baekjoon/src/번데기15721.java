import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 번데기15721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        System.out.println(game(A, T, N));
    }

    private static int game(int A, int T, int N) {
        int cnt = 2;
        int bun = 0;
        int degi = 0;

        while(true) {
            for(int i = 0; i < 4; i++) {
                if(i % 2 == 0) bun++;
                else degi++;

                if(bun == T && N == 0) return (bun + degi - 1) % A;
                if(degi == T && N == 1) return (bun + degi - 1) % A;
            }

            for(int j = 0; j < cnt; j++) {
                bun++;
                if(bun == T && N == 0) return (bun + degi - 1) % A;
            }

            for(int j = 0; j < cnt; j++) {
                degi++;
                if(degi == T && N == 1) return (bun + degi - 1) % A;
            }

            cnt++;
        }
    }
}
