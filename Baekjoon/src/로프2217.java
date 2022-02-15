import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 나는 항상 정렬이 나오면 PQ 꺼낼 생각부터 하지만
// PQ보다 때로는 배열이 더 빠를 때가 있다.
public class 로프2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        // 최고로 견딜 수 있는 무게이므로
        // 현재 로프들 중에서 가장 적은 무게를 견딜 수 있는 로프 X 로프 개수 = 최대 중량이다.
        int max = 0;
        for(int i = 0; i < N; i++) {
            max = Math.max(max, numbers[i] * (N - i));
        }

        System.out.println(max);
    }
}
