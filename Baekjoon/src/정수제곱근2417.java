import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 정수제곱근2417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long number = Long.parseLong(br.readLine());
        System.out.println(binarySearch(number));
    }

    private static long binarySearch(long n) {
        if(n == 0) return 0;

        long left = 0;
        long right = (long)Math.sqrt(Long.MAX_VALUE);
        while(left <= right) {
            long mid = (left / 2) + (right / 2);
            if(left % 2 == 1 && right % 2 == 1) mid++;

            if(mid * mid == n) return mid;
            else if(mid * mid < n) left = mid + 1;
            else right = mid - 1;
        }

        return left;
    }
}
