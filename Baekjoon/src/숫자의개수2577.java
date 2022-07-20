import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의개수2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 1;
        for(int i = 0; i < 3; i++) {
            result *= Integer.parseInt(br.readLine());
        }

        int[] numbers = new int[10];
        while(result > 0) {
            numbers[result % 10]++;
            result /= 10;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++) {
            sb.append(numbers[i]).append("\n");
        }

        System.out.println(sb);
    }
}
