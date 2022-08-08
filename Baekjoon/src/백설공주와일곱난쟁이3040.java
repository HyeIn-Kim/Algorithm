import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 백설공주와일곱난쟁이3040 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dwarfs = new int[9];
        int sum = 0;
        for(int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
            sum += dwarfs[i];
        }

        StringBuilder sb = new StringBuilder();
        outer:
        for(int i = 0; i < 9; i++) {
            for(int j = i + 1; j < 9; j++) {
                if(dwarfs[i] + dwarfs[j] == sum - 100) {
                    for(int k = 0; k < 9; k++) {
                        if(k == i || k == j) continue;
                        sb.append(dwarfs[k]).append("\n");
                    }
                    break outer;
                }
            }
        }

        System.out.println(sb);
    }
}
