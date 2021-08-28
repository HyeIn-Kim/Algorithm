import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 직사각형을만드는방법8320 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 숫자 6으로 만들 수 있는 직사각형 i x j는
		// 1x1 1x2 1x3 1x4 1x5 1x6
		// 2x1 2x2 2x3
		// 3x2 이렇게 총 10개
		// 이중에서 한번 나온 직사각형은 세지 않으므로
		// j는 i부터 시작해서 세주었다.
		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			for(int j = i; j <= N; j++) {
				if(i * j <= N) cnt++;
			}
		}
		System.out.println(cnt);
	}

}
