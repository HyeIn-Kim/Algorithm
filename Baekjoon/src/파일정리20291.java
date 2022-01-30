import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class 파일정리20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> map = new TreeMap<>();
        for(int i = 0; i < N; i++) {
            // split() 메소드 안에는 정규식이 들어가는거라 .을 쓸때는 \\.으로 써주어야 작동한다고 함
            String[] input = br.readLine().split("\\.");
            map.put(input[1], map.getOrDefault(input[1], 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }

        System.out.println(sb);
    }
}
