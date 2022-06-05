import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블로그21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = X;
        int sum = 0;
        for(int i = start; i < end; i++) {
            sum += arr[i];
        }

        int max = sum, maxCnt = 1;
        while(start < N && end < N) {
            sum = sum - arr[start] + arr[end];
            if(sum > max) {
                max = sum;
                maxCnt = 1;
            }
            else if(sum == max) {
                maxCnt++;
            }

            start++;
            end++;
        }

        if(max == 0) System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(maxCnt);
        }
    }
}
