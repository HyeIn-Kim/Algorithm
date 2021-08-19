package swea.d3;

import java.util.Scanner;

public class 회문2 {

	static int N;
	static char[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int T = 1; T <= 10; T++) {
			int testCase = sc.nextInt();
			N = 100;
			map = new char[N][N];
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				for(int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {					
					max = Math.max(max, cntHorizontalPalindrome(i, j));
					max = Math.max(max, cntVerticalPalindrome(i, j));
				}
			}
			
			System.out.println("#" + T + " " + max);
		}

	}
	
	// 가로 회문 검사
	private static int cntHorizontalPalindrome(int r, int c) {
		// 맨 끝부터 c까지 회문 비교 시작
		for(int n = N; n > c; n--) {
			// 양 끝을 계속 비교해나갈 것이므로, 홀수일 경우에는 ABCBA의 C처럼 카운트되지 않는다.
			// 따라서 회문 글자수(n-c)가 1이라면 cnt는 1부터 시작
			// n-c인 이유는, 만약 c가 3이고 n이 100이라면, 회문 길이는 100 - 3 = 97글자가 되기 때문.
			int cnt = ((n-c) % 2 == 0) ? 0 : 1;
			boolean isPalindrome = true;
			for(int i = 0; i < (n-c) / 2; i++) {
				// 대칭되는 문자가 같지 않다면 회문이 아니므로 종료한다.
				if(map[r][c + i] != map[r][n - i - 1]) {
					isPalindrome = false;
					break;
				}
				cnt+=2;
			}
			// 회문이라면 cnt를 반환하고 종료한다.
			// 100부터 c까지 내려오고 있기 때문에, 한번 회문이라면
			// 다음번 회문은 무조건 더 짧은 길이라서 더 검사할 필요가 없음. 
			if(isPalindrome) {
				return cnt;
			}
		}
	
		return 0;
	}

	// 세로 회문 검사. 가로랑 동일하게 작동하고 범위만 세로이다.
	private static int cntVerticalPalindrome(int r, int c) {
		for(int n = N; n > r; n--) {
			int cnt = ((n-r) % 2 == 0) ? 0 : 1;
			boolean isPalindrome = true;
			for(int i = 0; i < (n-r) / 2; i++) {
				if(map[r + i][c] != map[n - i - 1][c]) {
					isPalindrome = false;
					break;
				}
				cnt+=2;
			}
			if(isPalindrome) {
				return cnt;
			}
		}
	
		return 0;
	}
}
