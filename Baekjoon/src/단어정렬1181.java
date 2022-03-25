import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class 단어정렬1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> set = new TreeSet<>((o1, o2) -> {
            if(o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            else return o1.length() - o2.length();
        });

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for(String str : set) {
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }
}
