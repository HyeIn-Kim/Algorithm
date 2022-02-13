import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 폴리오미노1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        for(int i = 0; i < input.length; i++) {
            if(input[i] == 'X') {
                int cnt = 1;
                // 앞으로 4칸, 연속 X인지 확인
                for(int j = 1; j < 4; j++) {
                    if(i + j < input.length && input[i + j] == 'X') cnt++;
                    else break;
                }

                // A를 넣을 수 있으면 A를 넣고
                if(cnt == 4) {
                    for(int j = 0; j < 4; j++) {
                        input[i + j] = 'A';
                    }
                }
                // B를 넣을 수 있다면 B를 넣음
                else if(cnt == 2) {
                    for(int j = 0; j < 2; j++) {
                        input[i + j] = 'B';
                    }
                }
                // 둘다 아니라면 못차움. -1 출력후 종료
                else {
                    System.out.println(-1);
                    return;
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length; i++) {
            sb.append(input[i]);
        }

        System.out.println(sb);
    }
}
