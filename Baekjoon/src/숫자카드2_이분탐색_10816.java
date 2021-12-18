import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이분탐색 버전
public class 숫자카드2_이분탐색_10816 {

	static int N;
	static int[] numbers;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		numbers = new int[N];
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());
			int right = upperBinarySearch(key);
			int left = lowerBinarySearch(key);
			sb.append((right - left) + " ");
		}
		
		System.out.println(sb.toString());
	}
	
	// upperBinarySearch: 찾는 값 key보다 첫번째로 큰 index를 리턴
	private static int upperBinarySearch(int key) {
		int left = 0;
		// 주의할 점: 예시에서 upperBinarySearch(10)을 하면 배열 크기인 10이 나와야 하므로
		// 이분탐색처럼 N-1이 아니라 N부터 시작한다.
		int right = N;
		
		while(left < right) {
			int mid = (left + right) / 2;
			// 현재 위치가 찾으려는 값보다 같거나 클 경우 left를 당겨주고
			if(key >= numbers[mid]) left = mid + 1;
			// 아니면 right를 mid로
			else right = mid;
		}
		
		return left;
	}
	
	// lowerBinarySearch: 찾는 값 key와 같거나 큰 값이 처음으로 나오는 index를 리턴
	private static int lowerBinarySearch(int key) {
		int left = 0;
		int right = N;
		
		while(left < right) {
			int mid = (left + right) / 2;
			// 현재 위치가 찾으려는 값보다 작거나 같을 경우 right를 mid로
			if(key <= numbers[mid]) right = mid;
			// 아니면 left = mid + 1
			else left = mid + 1;
		}
		
		return left;
	}

}
