import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 듣보잡1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        TreeSet<String> noSee = new TreeSet<>();
        TreeSet<String> noHear = new TreeSet<>();
        for(int i = 0; i < N; i++) {
            noSee.add(br.readLine());
        }
        for(int i = 0; i < M; i++) {
            noHear.add(br.readLine());
        }

        noSee.retainAll(noHear);
        StringBuilder sb = new StringBuilder();
        sb.append(noSee.size()).append("\n");
        for(String str : noSee) {
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }
}
