import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 이구역의승자는누구야20154 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] table = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};
        char[] input = br.readLine().toCharArray();
        int K = input.length;
        int[] curr = new int[K];
        for(int i = 0; i < K; i++) {
            curr[i] = table[input[i] - 'A'];
        }

        while(K > 1) {
            int L = K % 2 == 0 ? K/2 : K/2+1;
            int[] next = new int[L];
            for(int i = 1; i < K; i += 2) {
                next[i/2] = (curr[i-1] + curr[i]) % 10;
            }

            if(K % 2 == 1) next[L-1] = curr[K-1];

            curr = next;
            K = L;
        }

        System.out.println(curr[0] % 2 == 1 ? "I'm a winner!" : "You're the winner?");
    }
}
