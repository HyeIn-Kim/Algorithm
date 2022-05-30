import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 블로그2_20365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] colors = br.readLine().toCharArray();
        int cntB = colors[0] == 'B' ? 1 : 0;
        int cntR = colors[0] == 'R' ? 1 : 0;

        for(int i = 1; i < colors.length; i++) {
            if(colors[i-1] == colors[i]) continue;
            if(colors[i] == 'B') cntB++;
            else cntR++;
        }

        System.out.println(Math.min(cntB, cntR) + 1);
    }
}
