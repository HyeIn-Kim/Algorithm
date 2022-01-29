import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 거스름돈14916  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int min = -1;
        // 5원이 가장 많을 때부터 5원짜리를 하나씩 빼면서 거스름돈을 줄 수 있을때면 종료
        // 동전 가격이 비싼게 많을수록 더 적은 동전으로 거스름돈을 줄 수 있기 때문
        for(int i = n / 5; i >= 0; i--) {
            int left = n - (i * 5);
            int cnt = i + (left / 2);
            if(left % 2 == 0) {
                min = cnt;
                break;
            }
        }

        System.out.println(min);
    }
}
