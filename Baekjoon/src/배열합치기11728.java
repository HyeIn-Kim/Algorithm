import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열합치기11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] a = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] b = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while(i < N && j < M) {
            if(a[i] < b[j]) {
                sb.append(a[i++]).append(" ");
            }
            else if(a[i] > b[j]) {
                sb.append(b[j++]).append(" ");
            }
            else {
                sb.append(a[i++]).append(" ");
                sb.append(b[j++]).append(" ");
            }
        }

        while(i < N) {
            sb.append(a[i++]).append(" ");
        }

        while(j < M) {
            sb.append(b[j++]).append(" ");
        }

        System.out.println(sb);
    }
}
