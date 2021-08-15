import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class n과m9 {

	static int N, M;
	static int[] input;
	static int[] numbers;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		input = new int[N];
		numbers = new int[M];
		isSelected = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		Arrays.sort(input);
		Permutation(0);
		System.out.println(sb);
	}
	
	private static void Permutation(int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		// 중복을 거르기 위한 set을 만듦.
		// 이 set은 순열에 특정 숫자가 들어갔는지 아닌지를 판단할거임.
		// 따라서 함수(순열) 마다 있음.
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0; i < N; i++) {
			// 숫자가 이미 선택되었거나
			// 이미 뽑은 숫자라면 continue
			if(isSelected[i]) {
				continue;
			}
			if(set.contains(input[i]))
				continue;
			
			// for문을 돌면서 순열로 뽑은 숫자를 set에 넣는다.
			set.add(input[i]);
			numbers[cnt] = input[i];
			isSelected[i] = true;
			Permutation(cnt + 1);
			isSelected[i] = false;
		}
	}

}
