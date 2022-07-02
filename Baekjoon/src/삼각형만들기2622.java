import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 삼각형만들기2622 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        // 삼각형의 조건: 가장 긴 변 < 나머지 두 변의 합
        // a >= b >= c, 3 변으로 둔다.
        // 가장 긴 변은 나머지 두 변의 합보다 작아야 하기 때문에 N/2를 넘을 수 없다.
        // 또, 나머지 두 변보다 길어야 하기 때문에 N/3보다 작을 수 없다.
        for(int a = N / 2; a >= N / 3; a--) {
            // a >= b >= c를 구한다.
            for(int b = a; b >= 1; b--) {
                int c = N - a - b;

                // c가 만약 0보다 작아지면 길이 N의 삼각형을 만들 수 없음
                // 중복을 막기 위해 b >= c인 값들만 검사.
                // 중복 제거를 어떻게 하지? set인가? 하고 한참 고민했는데 아주아주 간단한 방법이 있었다...ㅠ
                if(c <= 0 || c > b) break;
                else cnt++;
            }
        }

        System.out.println(cnt);
    }
}
