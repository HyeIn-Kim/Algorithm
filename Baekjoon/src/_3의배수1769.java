import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3의배수1769 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int x = 0;
        for(int i = 0; i < input.length(); i++) {
            x += input.charAt(i) - '0';
        }

        String answer = "NO";
        int cnt = 1;
        if(x < 10) {
            if(x % 3 == 0) answer = "YES";
            cnt = 0;
        }
        else {
            while(true) {
                if(x < 10) {
                    if(x % 3 == 0) answer = "YES";
                    break;
                }

                int y = 0;
                while(x > 0) {
                    y += x % 10;
                    x /= 10;
                }

                cnt++;
                x = y;
            }
        }

        System.out.println(cnt);
        System.out.println(answer);
    }
}
