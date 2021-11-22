import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 접근 1. 가장 긴 증가수열 + 가장 긴 감소수열 - 1
// 1 5 2 1 4 3 4 5 2 1 (1-2-3-4-5-2-1) 을 보자.
// 가장 긴 증가수열은 1 2 3 4 5 이고
// 가장 긴 감소수열은 5 4 3 2 1 이다. 순서대로 합치면 바이토닉 수열이 안된다.

// 접근 2. 가장 긴 증가수열 + 그 뒤부터 감소수열 - 1 or
// 증가수열 + 가장 긴 감소수열 - 1
// 9 1 2 3 2 1 9 (1-2-3-2-1) 을 보자.
// 가장 긴 증가수열은 1 2 3 9 + 감소수열 9 - 1 => 4
// 증가수열 9 + 가장 긴 감소수열 9 3 2 1 - 1 => 4
// 배열을 모두 찍어보니 가장 긴~ 의 위치를 신경 쓸 필요 없이,
// 둘의 합 - 1이 최대가 되는 곳을 찾으면 답이라는 걸 알게 되었다!

// 접근 3. 가장 긴 증가수열, 감소수열을 구해서
// 둘의 합 - 1 이 최대가 되는 곳을 찾는다. (정답!)
public class 가장긴바이토닉부분수열11054 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] numbers = new int[N];
		for(int i = 0; i < N; i++) {
			numbers[i] =  Integer.parseInt(st.nextToken());
		}
		
		int[] DP = new int[N];
		int max = 0;
		for(int i = 0; i < N; i++) {
			DP[i] = 1;
			for(int j = 0; j < i; j++) {
				if(numbers[j] < numbers[i] && DP[j] + 1 > DP[i]) {
					DP[i] = DP[j] + 1;
				}
			}
			
			max = Math.max(max, DP[i]);
		}
		
		// 감소수열을 뒤에서부터 찾았는데, 앞에서부터 찾으면
		// 앞의 for문이랑 같이 구함 -> 시간 단축이 될지도?
		int[] DP2 = new int[N];
		int max2 = 0;
		for(int i = N-1; i >= 0; i--) {
			DP2[i] = 1;
			for(int j = N-1; j > i; j--) {
				if(numbers[j] < numbers[i] && DP2[j] + 1 > DP2[i]) {
					DP2[i] = DP2[j] + 1;
				}
			}
			
			max2 = Math.max(max2, DP2[i]);
		}		
		
		int result = 0;
		for(int i = 0; i < N; i++) {
			result = Math.max(result, DP[i] + DP2[i] - 1);
		}
		System.out.println(result);
	}

}
