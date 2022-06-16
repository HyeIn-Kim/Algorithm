import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최댓값2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int idx = 0;
        for(int i = 1; i <= 9; i++) {
            int number = Integer.parseInt(br.readLine());
            if(max < number) {
                max = number;
                idx = i;
            }
        }

        System.out.println(max);
        System.out.println(idx);
    }
}
