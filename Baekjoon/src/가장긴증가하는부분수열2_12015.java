import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// LIS O(NlogN) 방법
// LIS를 카운트할 임시 배열을 만들어 놓고
// 배열의 맨 마지막 수보다 현재 값이 클 때는 맨 뒤에 넣고
// 작을 때는 이분 탐색으로 위치를 찾아서 값을 교체한다.
// 처음엔 응..? 왜...? 그럴 필요가 있는거지...? 했는데
// 10 20 30 1 2 3 4 예제에서는
// 10 20 30 | 1 2 3 4 까지 봤을 때
// 배열에 10 20 30 이 있고
// 10 20 30 1 | 2 3 4 가 되면
// 이분탐색으로 1이 들어갈 위치를 찾아서 1 20 30 이 된다!!
// 10 20 30 1 2 3 | 4 --> 1 2 3 으로 교체된 뒤 4가 맨 뒤에 와서
// 1 2 3 4 => LIS : 4 가 된다.
// 여기서 주의할 점은 배열 길이가 LIS라고 해서
// 배열 안의 숫자가 LIS의 원소는 아니다..!
public class 가장긴증가하는부분수열2_12015 {

	static int N;
	static int[] arr, LIS;
	static int idx, max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		max = Integer.MIN_VALUE;
		
		LIS = new int[N];
		idx = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			// 첫 칸 or 현재 값이 가장 크다면 배열에 삽입
			if(idx == 0 || LIS[idx-1] < arr[i]) {
				LIS[idx++] = arr[i];
			}
			// 현재 값이 배열 맨 끝보다 작을 경우
			// 이분탐색 수행해서 배열의 값을 교체
			else {
				int loweridx = lowerBinarySearch(arr[i]);
				LIS[loweridx] = arr[i];
			}
		}
		
		System.out.println(idx);
	}

	private static int lowerBinarySearch(int n) {
		int left = 0;
		int right = idx-1;
		
		while(left < right) {
			int mid = (left + right) / 2;
			if(LIS[mid] < n) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		
		return left;
	}

}
