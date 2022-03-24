import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 그룹단어체커1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int n = 0; n < N; n++) {
            char[] input = br.readLine().toCharArray();
            boolean[] alphabet = new boolean[26];
            for(int i = 0; i < input.length; i++) {
                if(alphabet[input[i] - 'a']) {
                    if(input[i-1] == input[i]) continue;
                    // 그룹 단어가 아닌 것들의 개수를 세서, 전체에서 빼기로 함
                    cnt++;
                    break;
                }
                else {
                    alphabet[input[i] - 'a'] = true;
                }
            }
        }

        System.out.println(N - cnt);
    }
}
