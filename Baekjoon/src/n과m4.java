import java.util.Scanner;

public class n과m4 {

	static int N, M;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		
		Combination(0, 0);
		System.out.println(sb);
	}
	
	private static void Combination(int start, int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i < N; i++) {
			numbers[cnt] = i + 1;
			Combination(i, cnt + 1);
		}
	}

}
