import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암기왕2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int testcase = 1; testcase <= T; testcase++) {
            int N = Integer.parseInt(br.readLine());
            int[] note1 = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                note1[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(note1);

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                int number = Integer.parseInt(st.nextToken());
                sb.append(binarySearch(number, note1) ? 1 : 0).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean binarySearch(int number, int[] note1) {
        int left = 0;
        int right = note1.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(note1[mid] == number) return true;
            else if(note1[mid] > number) right = mid - 1;
            else left = mid + 1;
        }

        return false;
    }
}
