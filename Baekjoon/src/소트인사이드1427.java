import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 소트인사이드1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        while(N > 0) {
            list.add(N % 10);
            N /= 10;
        }

        Collections.sort(list);
        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        for(Integer i : list) {
            sb.append(i);
        }

        System.out.println(sb);
    }
}
