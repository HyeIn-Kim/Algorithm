import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 완전 쉬운 Set 기본문제
public class 문자열집합14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        int cnt = 0;
        for(int i = 0; i < M; i++) {
            if(set.contains(br.readLine())) cnt++;
        }

        System.out.println(cnt);
    }
}
