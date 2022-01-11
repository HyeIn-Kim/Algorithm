import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _8진수2진수1212 {
    public static void main(String[] args) throws Exception {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();

        int size = input.length;
        if(size == 1 && input[0] == '0') {
            System.out.println(0);
            return;
        }

        // 모든 문자를 앞에서 돌면서
        for(int i = 0; i < size; i++) {
            int curr = input[i] - '0';
            StringBuilder temp = new StringBuilder();
            // 8진수 -> 2진수 변환은 3 -> 011 이렇게 3글자씩 끊는다.
            for (int j = 0; j < 3; j++) {
                // 0이 아니면 2로 나눈 나머지를 추가하고, 0일때는 0으로 채움
                if (curr > 0) {
                    temp.insert(0, (curr % 2 == 0) ? 0 : 1);
                    curr /= 2;
                } else temp.insert(0, 0);
            }

            // 구한 2진수를 붙인다
            sb.append(temp);
        }

        // 첫 1이 나오는부분을 찾아서 거기서부터 끝까지 출력!
        int start = sb.indexOf("1");
        System.out.println(sb.substring(start, sb.length()));
    }
}
