import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 염색체9342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            sb.append(br.readLine().matches("[A-F]?A+F+C+[A-F]?") ? "Infected!" : "Good").append("\n");
        }
        System.out.println(sb);
    }
}
