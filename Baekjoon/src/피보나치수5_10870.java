import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수5_10870 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(fibo(N));
	}

	private static int fibo(int n) {
		// 0과 1부터 시작하므로 이때는 각각 0, 1을 리턴
		if(n == 0 || n == 1) return n;
		
		// n-1까지의 합과 n-2까지의 합을 리턴
		return fibo(n-1) + fibo(n-2);
	}

}
