import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 나는야포켓몬마스터이다솜1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // map을 하나만 만들었을 때는 숫자 -> 바로 찾고, 문자열 -> 맵을 다 돌면서 찾았다가 시간초과가 났는데
        // 그냥 간단하게 map을 2개 만들면 끝나는... 일이었다...!
        HashMap<Integer, String> numbers = new HashMap<>();
        HashMap<String, Integer> strings = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            String input = br.readLine();
            numbers.put(i, input);
            strings.put(input, i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            String input = br.readLine();
            if('1' <= input.charAt(0) && input.charAt(0) <= '9') {
                int index = Integer.parseInt(input);
                sb.append(numbers.get(index) + "\n");
            }
            else {
                sb.append(strings.get(input) + "\n");
            }
        }

        System.out.println(sb);
    }
}
