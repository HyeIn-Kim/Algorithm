import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 아~~!! 답은 맞았는데 출력 예제를 1줄이 아니라 1줄 + 공백1줄 이렇게 봄
public class 별찍기19_10994 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int size = (N-1) * 4 + 1;
        char[][] arr = new char[size][size];
        int start = 0, end = size - 1;
        // 시작점, 끝점을 정해서 둘이 만날 때까지 네모로 별을 찍으면 끝
        while(start <= end) {
            for(int i = start; i <= end; i++) {
                arr[start][i] = '*';
                arr[end][i] = '*';
                arr[i][start] = '*';
                arr[i][end] = '*';
            }

            start += 2; end -= 2;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                sb.append(arr[i][j] == '*' ? arr[i][j] : " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
