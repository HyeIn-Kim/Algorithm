import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 처음에는 첫번째 집과 나머지 집의 거리로 이분탐색을 돌렸는데,
// 나머지 집들의 거리가 더 가까울 경우를 계산 못해서 틀렸다.
// 판별함수도 이분탐색도 안어려웠는데 접근을 잘못해서 한참 헤맸다...!!
public class 공유기설치2110 {

	static int N, C;
	static int[] houses;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		houses = new int[N];
		for(int i = 0; i < N; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
		
		// 이분탐색 전 정렬 필수!
		Arrays.sort(houses);
		
		System.out.println(parameticSearch());
	}

	private static int parameticSearch() {
		int left = 1;						 // 최소 거리인 1로
		int right = houses[N-1] - houses[0]; // 최대 거리는 마지막 집 - 첫번째 집
		int answer = 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			int cnt = setRouter(mid);
			if(cnt < C) right = mid - 1;
			else {
				answer = mid;
				left = mid + 1;
			}
		}
		
		return answer;
	}

	private static int setRouter(int n) {
		int cnt = 1;
		int num = houses[0];	// 기준 집
		for(int i = 1; i < N; i++) {
			// 거리를 충족하면 공유기 설치
			if(houses[i] - num >= n) {
				cnt++;
				// 기준집 변경
				num = houses[i];
			}
		}
		
		return cnt;
	}

}
