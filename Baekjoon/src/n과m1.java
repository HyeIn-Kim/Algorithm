import java.util.Scanner;

// 순열
public class n과m1 {

	static int N, M;
	static int[] numbers;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		isSelected = new boolean[N];
		
		Permutation(0);
		System.out.println(sb);
	}
	
	private static void Permutation(int index) {
		if(index == M) {
			for(int i = 0; i < M; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			numbers[index] = i + 1;
			isSelected[i] = true;
			Permutation(index + 1);
			isSelected[i] = false;
		}
	}
}
