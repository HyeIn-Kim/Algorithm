import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

// 무슨 문제가!!!!!!!!
// 문제보다 입출력이 더 화남!!!!!!!!!!!!!
public class 생태학4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // TreeMap을 사용하면 사전 순으로 출력할 수 있다.
        TreeMap<String, Integer> map = new TreeMap<>();

        // 무한입력.. 너무 힘들었다.
        int cnt = 0;
        while(true) {
            String input = br.readLine();
            // br.readLine()은 입력이 없으면 null을 반환한다.
            // 입력이 없거나 아무것도 입력되지 않으면 종료한다.
            if(input == null || input.equals("")) break;

            // cnt에 총 입력 개수를 세 주고
            // map에 해당 나무가 몇 번 나왔는지 갱신한다.
            cnt++;
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        // 처음부터 돌면서 나무를 쭉 출력해주면 끝!
        StringBuilder sb = new StringBuilder();
        for(String tree : map.keySet()) {
            sb.append(String.format("%s %.4f\n", tree, (double)map.get(tree) / cnt * 100));
        }
        System.out.println(sb);
    }
}