package swea.d3;

import java.util.Scanner;

public class 부먹왕궁의차원관문 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();	// 도시 수
			int D = sc.nextInt();	// 제한거리
			int[] city = new int[N];
			for(int i = 0; i < N; i++) {
				city[i] = sc.nextInt();
			}
			
			int idx = 0;
			// 첫번째 도시에 차원관문이 없다면 설치해야 하므로 1부터 시작
			// 이미 세워져 있는 경우 0부터
			int cnt = (city[0] == 1) ? 0 : 1;
			outer: while(idx < N) {
				for(int i = 1; i <= D; i++) {
					// 거리 D 안에 다른 차원관문이 있다면
					// 다음 차원관문으로 이동
					if(idx+i < N && city[idx+i] == 1) {
						idx += i;
						continue outer;
					}
				}
				
				// 거리 D 안에 다른 차원관문이 없을 경우
				// 현재위치 + D에 새로운 차원관문 설치
				if(idx+D < N) {
					city[idx+D] = 1;
					cnt++;
				}
				idx += D;
			}
			sb.append("#" + testCase + " " + cnt + "\n");
		}
		System.out.println(sb);
	}

}
