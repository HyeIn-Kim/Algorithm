import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N개의 숫자 중 N개를 뽑는 순열!
// 위치(index)에 따라서 결과값이 변하므로 순서 상관 O, 순열임
// 한번 사용된 수는 다시 나올 수 없음. 중복 X
public class 차이를최대로10819 {

	static int N;					// 입력 개수 = 순열 개수 N
	static int[] input;				// 입력값
	static boolean[] isSelected;	// 선택 배열

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// static 변수 초기화
		input = new int[N];
		isSelected = new boolean[N];
		max = Integer.MIN_VALUE;		// 결과값을 담을 Max
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		permutation(0, 0, 0);
		System.out.println(max);
	}
	
	// 재귀 돌면서 차이의 최댓값을 구하려고 인자로 넣었음
	// prev: 이전 인덱스 수: | prev - 현재값 | 으로 차이에 더해주기 위함
	// sum: 차이의 합 (기저부분에서 max와 비교함)
	// cnt: 순열을 몇개 뽑았는지
	static int max;
	private static void permutation(int prev, int sum, int cnt) {
		if(cnt == N) {
			max = Math.max(sum, max);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			// 선택
			isSelected[i] = true;
			// index가 0일때는 차이를 구하지 않으므로 0, 나머지는 prev와의 차이를 구함
			int diff = (cnt == 0) ? 0 : Math.abs(prev - input[i]);
			// 다음 자리수 구하러 재귀
			permutation(input[i], sum + diff, cnt + 1);
			// 선택 해제
			isSelected[i] = false;
		}
	}
}
