import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 복호화9046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            int[] cnt = new int[26];
            char[] input = br.readLine().toCharArray();
            // 알파벳 빈도수를 세고
            for(int i = 0; i < input.length; i++) {
                if(input[i] == ' ') continue;
                cnt[input[i] - 'a']++;
            }

            // 가장 많이 나온 값을 파악
            int max = 0;
            for(int i = 0; i < 26; i++) {
                max = Math.max(max, cnt[i]);
            }

            // 빈도수가 가장 많은 값들을 찾는다.
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < 26; i++) {
                if(cnt[i] == max) list.add(i);
            }

            // 2개 이상이면 ?, 1개일땐 문자로!
            if(list.size() > 1) sb.append("?").append("\n");
            else sb.append((char)('a' + list.get(0))).append("\n");
        }

        System.out.println(sb);
    }
}
