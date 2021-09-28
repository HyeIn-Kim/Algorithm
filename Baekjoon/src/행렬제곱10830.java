import java.util.Scanner;

public class 행렬제곱10830 {

	static int T = 1000;	// 나머지
	static int[][] m;		// 입력 행렬
	static int N;			// 행렬 크기 N
	static long B;			// B 제곱
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		B = sc.nextLong();
		m = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				m[i][j] = sc.nextInt() % T;
			}
		}

		// 행렬 A에 B제곱을 한다!
		int[][] mm = matrix(B);
		
		// 출력
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(mm[i][j] + " ");
			}
			System.out.println();
		}
	}

	// 분할정복 접근법!
	// A^5 일때
	// = A * A^4
	// = A * A^2 * A^2
	private static int[][] matrix(long y) {
		// 단위행렬 만들기
		int[][] res = new int[N][N];
		for (int i = 0; i < N; i++) {
			res[i][i] = 1;
		}
		
		// 기저조건. 단위행렬을 return
		// 참고: 행렬 A에 단위행렬을 곱하면 값이 변하지 않고 그대로 행렬 A가 나온다.
		if(y == 0) {
			return res;
		}
		
		// y가 홀수일 때는 A * A^4 처럼
		// 행렬 A를 결과행렬에 한번 더 곱해줌!
		if(y % 2 == 1) {
			res = mul(res, m);
		}
		
		// 분할정복기법을 사용하여
		// A^N/2 * A^N/2를 결과행렬에 곱해주었음
		int[][] tmp = matrix(y / 2);
		res = mul(res, mul(tmp, tmp));		
		
		return res;
	}

	// 행렬곱셈 함수.
	// 계산할 때마다 T로 나눠주자!
	private static int[][] mul(int[][] r, int[][] x) {
		int[][] res = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int t = 0;
				for (int k = 0; k < N; k++) {
					t = (t % T + (r[i][k] * x[k][j]) % T) % T;
				}
				res[i][j] = t % T;
			}
			
		}
		return res;
	}

}
