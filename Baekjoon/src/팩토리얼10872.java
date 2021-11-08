import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 재귀함수 버전
public class 팩토리얼10872 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(factorial(N));
	}

	private static int factorial(int n) {
		// 0이거나 1일때는 1을 반환하고
		if(n == 0 || n == 1) return 1;
		
		// 5! (1x2x3x4x5)를 생각해보자.
		// 5 x 4! (1x2x3x4)로 표현할 수 있고
		// 4!는 4 x 3! 이다. 나 자신 x (n-1)! 으로 나타낼 수 있다.
		return n * factorial(n-1);
	}

}
