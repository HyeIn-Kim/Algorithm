import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class n과m12 {

	static int N, M;
	static int[] input;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		input = new int[N];
		numbers = new int[M];
		
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		Arrays.sort(input);
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
		
		HashSet<Integer> set = new HashSet<>();
		for(int i = start; i < N; i++) {
			if(set.contains(input[i])) continue;
			
			set.add(input[i]);
			numbers[cnt] = input[i];
			Combination(i, cnt + 1);
		}
	}

}
