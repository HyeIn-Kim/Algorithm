import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이분탐색 직접 구현한 문제.
public class 수찾기1920 {

	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 이분탐색 하기 전, 반드시 정렬되어야 함을 잊지 말기!
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] find = new int[M];
		for(int i = 0; i < M; i++) {
			find[i] = Integer.parseInt(st.nextToken());
			sb.append((binarySearch(find[i]) ? "1" : "0") + "\n");
		}
		
		System.out.println(sb.toString());

	}
	
	// 값을 찾으면 true, 못찾으면 false를 반환
	private static boolean binarySearch(int n) {
		int left = 0;
		int right = N-1;
		
		while(left <= right) {
			int idx = (left + right) / 2;
			if(n == arr[idx]) return true;
			else if(n < arr[idx]) {
				right = idx - 1;
			}
			else if(n > arr[idx]) {
				left = idx + 1;
			}		
		}
		
		return false;
	}

}
