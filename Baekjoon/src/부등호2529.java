import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 문제 접근!
// 입력값은 0 ~ 9. 만약 오름차순 정렬(0123456789)로 놓고 순열을 구한다면
// 첫번째로 부등호 조건을 만족하면 min, 마지막으로 부등호 조건을 만족하면 max값이 된다.
// 흠.. 다시 생각해보니 9876543210으로 풀었으면 배열 하나 덜쓰고 max-min 출력할 수 있었을 듯하다.
public class 부등호2529 {

	static int N;						// 부등호 개수 N (순열은 N+1개)
	static String[] op;					// 부등호 저장 배열
	static int[] input = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};	// 순열에 올 수 있는 숫자들
	static int[] numbers;				// 뽑은 순열
	static boolean[] isSelected;		// 선택 배열
	static boolean isFirst;				// min을 추리기 위해 첫번째 부등호 만족값인지 아닌지 판단함
	static int[] min;					// min 숫자들
	static int[] max;					// max 숫자들
	static StringBuilder sb;			// 출력용 StringBuilder
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// static 변수 초기화
		N = Integer.parseInt(br.readLine());
		numbers = new int[N+1];				// 부등호가 N개면 숫자는 N+1개 필요
		op = br.readLine().split(" ");
		isSelected = new boolean[10];
		isFirst = true;
		sb = new StringBuilder();
		
		permutation(0);
		
		// 출력 부분
		for(int i = 0; i < N+1; i++) {
			sb.append(max[i]);
		}
		sb.append("\n");
		for(int i = 0; i < N+1; i++) {
			sb.append(min[i]);
		}
		System.out.println(sb);
	}
	
	// param cnt: 현재까지 뽑은 순열 개수
	private static void permutation(int cnt) {
		if(cnt == N+1) {
			if(isFirst) {
				// 처음으로 부등호를 만족하면 min
				isFirst = false;
				min = Arrays.copyOf(numbers, cnt);
			} else {
				// 처음이 아니라면 부등호를 만족할 때마다 max에 갱신
				// 모든 재귀가 끝나면 max에는 가장 마지막 부등호 만족값이 들어감
				max = Arrays.copyOf(numbers, cnt);
			}
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			// 중복이 허용되지 않으므로 앞서 선택했다면 pass
			if(isSelected[i]) continue;
			// 부등호 만족하는지 판단할 boolean 변수
			boolean isEqual = true;
			
			if(cnt > 0) {
				// 이전 값과 현재 값이 부등호를 만족하는지 확인!
				if((op[cnt-1].equals("<") && !(numbers[cnt-1] < input[i]))
				|| (op[cnt-1].equals(">") && !(numbers[cnt-1] > input[i]))) {
					isEqual = false;
				}
			}
			
			// 부등호를 만족하지 않으면 pass
			if(!isEqual) continue;
			
			// 만족하면 순열에 넣고 다음자리로
			isSelected[i] = true;
			numbers[cnt] = input[i];
			permutation(cnt + 1);
			
			// 선택 해제
			isSelected[i] = false;
		}
	}

}
