import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 뭘 써야 할까? Map? Set? 고민했는데
// 잘 생각해 보니 평범하게 배열로도 충분히 풀 수 있었다.
public class 과제안내신분5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] student = new boolean[31];
        // 과제 낸 사람들을 체크하고
        for(int i = 0; i < 28; i++) {
            int N = Integer.parseInt(br.readLine());
            student[N] = true;
        }

        // 처음부터 돌면서 안 낸 사람들만 오름차순으로 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 30; i++) {
            if(student[i]) continue;
            sb.append(i + "\n");
        }

        System.out.println(sb);
    }
}
