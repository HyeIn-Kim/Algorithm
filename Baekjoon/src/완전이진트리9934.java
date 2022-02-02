import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 완전이진트리9934 {
    static int K, size;
    static int[] cbt;
    static StringTokenizer st = null;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        size = (int)Math.pow(2, K);
        cbt = new int[size];
        st = new StringTokenizer(br.readLine());

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < K; i++) {
            for(int j = (int)Math.pow(2, i); j < Math.pow(2, i+1); j++) {
                sb.append(cbt[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int n) {
        if(n < 1) return;

        // 1. 왼쪽 자식 검사: 방문하지 않았다면 왼쪽 자식으로 이동
        if(2 * n < size && cbt[2 * n] == 0) dfs(2 * n);

        // 2. 나를 방문하지 않았다면 나를 체크
        if(cbt[n] == 0) cbt[n] = Integer.parseInt(st.nextToken());

        // 3. 오른쪽 자식 검사: 방문하지 않았다면 오른쪽 자식으로 이동
        if((2 * n )+ 1 < size && cbt[(2 * n) + 1] == 0) dfs((2 * n) + 1);

        // 4. 자식이 없고 나도 방문했다면 부모로 이동
        dfs(n / 2);
    }
}
