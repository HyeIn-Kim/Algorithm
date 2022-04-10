import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 에너지드링크20115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] drinks = new double[N];
        for(int i = 0; i < N; i++) {
            drinks[i] = Double.parseDouble(st.nextToken());
        }

        Arrays.sort(drinks);
        double sum = drinks[N-1];
        for(int i = 0; i < N-1; i++) {
            sum += drinks[i]/2;
        }

        System.out.println(sum);
    }
}
