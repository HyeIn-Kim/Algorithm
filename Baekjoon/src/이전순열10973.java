import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이전순열10973 {

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
		if(prevPermutation()) {
			for(int i = 0; i < N; i++) {
				sb.append(numbers[i] + " ");
			}
		}
		else sb.append(-1);
		System.out.println(sb);
		
	}

	// Next Permutation 방법과 같게 접근하되,
	// 이전 순열을 만들어야 하므로 반대로 한다!
	private static boolean prevPermutation() {
		int i = N - 1;
		// step 1. 꼭대기(i)값 찾기
		// NP에서는 내림차순이 아닌 곳을 찾았는데,
		// 여기서는 오름차순이 아닌 위치를 찾는다.
		while(i > 0 && numbers[i-1] <= numbers[i]) --i;
		
		// 만약 i가 0이라면 1 2 3 4처럼
		// 사전 순으로 이전 순열이 없는 경우이므로 return false
		if(i == 0) return false;
		
		// step 2. i-1 위치값과 교환할 큰 값 찾기
		int j = N - 1;
		// 여기에서도 NP와 반대로 N-1부터 i-1보다 커지는 값을 찾는다!
		while(numbers[i-1] <= numbers[j]) --j;

		// step 3. i-1 위치값과 j 위치값을 교환
		swap(i-1, j);
		
		// step 4. 꼭대기(i)부터 맨 뒤까지 오름차순 형태의 순열을 내림차순으로 정리
		int k = N - 1;
		while(i < k) {
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
