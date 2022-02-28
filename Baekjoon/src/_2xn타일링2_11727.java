import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 노트에 사각형 수십개 그리면서 쇼했는데 점화식 못찾아서 결국 검색함,,
// 가로가 1인 타일 = 1종류 / 2인 타일 = 3종류인데 세로방향은 1이랑 겹치니까 뺌
// 즉 1인 타일 개수 + (2인 타일 개수) * 2 = 답
public class _2xn타일링2_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] DP = new int[N+1];
        if(DP.length >= 2) DP[1] = 1;
        if(DP.length >= 3) DP[2] = 3;
        for(int i = 3; i <= N; i++) {
            DP[i] = ((DP[i-1] % 10007) + (2 * (DP[i-2] % 10007) % 10007)) % 10007;
        }

        System.out.println(DP[N]);
    }
}
