import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기1759 {
    static int L, C;
    static String[] chars;
    static String[] selected;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        chars = br.readLine().split(" ");

        Arrays.sort(chars);

        selected = new String[L];
        sb = new StringBuilder();
        combination(0, 0);
        System.out.println(sb);
    }

    private static void combination(int idx, int start) {
        if(idx == L) {
            StringBuilder temp = new StringBuilder();
            int aeiou = 0;
            int alpha = 0;
            for(int i = 0; i < L; i++) {
                if(selected[i].equals("a") || selected[i].equals("e") || selected[i].equals("i") || selected[i].equals("o") || selected[i].equals("u")) aeiou++;
                else alpha++;

                temp.append(selected[i]);
            }

            if(aeiou >= 1 && alpha >= 2) sb.append(temp).append("\n");
            return;
        }

        for(int i = start; i < C; i++) {
            selected[idx] = chars[i];
            combination(idx + 1, i + 1);
        }
    }
}
