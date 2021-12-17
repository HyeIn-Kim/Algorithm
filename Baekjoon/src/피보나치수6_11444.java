import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 행렬을 사용해서 피보나치수를 O(logN)으로 구해보자!
// 피보나치 점화식 F(n) = F(n-1) + F(n-2)를 잘 정리해서 행렬로 나타내보면
// F(n) = [1 1  ^n * [1
//         1 0]       0] 이 되는데,
//        이 행렬을 n제곱하고 (0,1), (1,0) 자리에 오는 수가 F(n)이다.
public class 피보나치수6_11444 {

	static long N;
	static int mod = 1000000007;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Long.parseLong(br.readLine());
		
		long[][] matrix = {{1, 1}, {1, 0}};
		long[][] result = fibonacci(matrix, N);
		System.out.println(result[1][0]);
	}

	// 분할정복 거듭제곱으로 구해주면 되고
	private static long[][] fibonacci(long[][] m, long N) {
		if(N == 1) return m;
		
		if(N % 2 == 1) return multiple(m, fibonacci(m, N-1));
		else return fibonacci(multiple(m, m), N/2);
	}
	
	private static long[][] multiple(long[][] matrixA, long[][] matrixB) {
		long[][] result = new long[2][2];
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 2; j++) {
				for(int k = 0; k < 2; k++) {
					result[i][j] += (matrixA[i][k] * matrixB[k][j]) % mod;
				}
				// 주의할 점! 연산이 끝나고 최종 결과값이 mod를 넘어갈 수 있으므로
				// result를 mod로 나눠줘야 한다!
				result[i][j] %= mod;
			}
		}
		
		return result;
	}

}
