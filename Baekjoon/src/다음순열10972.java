import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다음순열10972 {

	static int N;
	static int[] numbers;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		if(nextPermutation()) {
			for(int i = 0; i < N; i++) {
				sb.append(numbers[i] + " ");
			}
		}
		else sb.append(-1);
		System.out.println(sb);
		
	}

	private static boolean nextPermutation() {
		int i = N - 1;
		// step1. 꼭대기(i)를 찾는다. 꼭대기를 통해 교환위치(i-1) 찾기
		// 맨 끝에서부터 내림차순이 아닌 부분을 찾으면 종료
		while(i > 0 && numbers[i-1] >= numbers[i]) --i;
		
		// i가 0이 되도록 찾지 못했다면 4 3 2 1처럼
		// 사전순으로 다음 순열이 없다. return false
		if(i == 0) return false;
		
		// step2. i-1 위치값과 교환할 큰 값(j) 찾기
		int j = N - 1;
		// i가 꼭대기이고 i-1은 꼭대기보다 작은 값이기 때문에
		// 남은 수중에서 i-1보다 큰 수는 항상 없다. (i-1가 꼭대기라면 이미 return됨)
		// 따라서 이 while문에는 j 조건을 걸어줄 필요가 없다.
		while(numbers[i-1] >= numbers[j]) --j;
		
		// step3. i-1 위치값과 j 위치값 교환
		swap(i-1, j);
		
		// step4. 꼭대기(i)부터 맨 뒤까지 내림차순 형태의 순열을 오름차순으로 처리
		int k = N - 1;
		while(i < k) {
			// i부터 k까지는 내림차순으로 정렬되어있기 때문에
			// i랑 k가 만날때까지 swap만 해주면 오름차순이 됨
			swap(i++, k--);
		}
		
		return true;
	}

	private static void swap(int i, int j) {
		int tmp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = tmp;
	}
}
