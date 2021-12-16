import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 행렬곱셈2740 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] matrixA = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				matrixA[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] matrixB = new int[M][K];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < K; j++) {
				matrixB[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// NxM 행렬과 MxK 행렬을 곱하면 NxK 크기의 행렬이 된다!
		StringBuilder sb = new StringBuilder();
		int result[][] = new int[N][K];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < K; j++) {
				// 각 칸마다 k개만큼 행렬곱셈한 결과를 더해주자!
				for(int k = 0; k < M; k++) {
					result[i][j] += matrixA[i][k] * matrixB[k][j];
				}
				sb.append(result[i][j] + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
