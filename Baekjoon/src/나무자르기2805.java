import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 처음에 문제를 잘못 이해했었다.
// 나무를 M만큼만 가져간다길래 딱 M인줄 알았는데
// 다시 읽어보니 적어도 M.. 즉 M 이상... 
// 랜선자르기랑 비슷하게 풀었다!
public class 나무자르기2805 {

	static int N, M, max;
	static int[] trees;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		trees = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, trees[i]);
		}
		
		System.out.println(parametricSearch());
	}

	private static int parametricSearch() {
		int left = 1;
		int right = max;
		int answer = 0;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			// left, right, mid는 int 범위지만 자른 나무의 개수 cnt는
			// 계산과정에 int 범위를 넘어버림!
			long cnt = cutTrees(mid);
			if(cnt < M) right = mid - 1;
			// 나무가 M개보다 같거나 많이 자를때마다 답을 갱신해준다!
			else {
				answer = mid;
				left = mid + 1;
			}
		}
		
		// 답을 리턴.
		return answer;
	}

	// 나무를 몇 개 자를 수 있는지 세는 함수.
	// 나무를 자를 수 있을 때만 잘라서 더해준다!
	private static long cutTrees(int n) {
		long cnt = 0;
		
		for(int i = 0; i < N; i++) {
			if(trees[i] > n) cnt += trees[i] - n;
		}
		
		return cnt;
	}

}
