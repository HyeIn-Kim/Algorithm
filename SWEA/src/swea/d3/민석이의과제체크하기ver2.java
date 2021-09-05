package swea.d3;

import java.util.Scanner;

public class 민석이의과제체크하기ver2 {

	// 나는 항상 오름차순 정렬만 보이면
	// PriorityQueue 쓸 생각만 해서 큰일이다...
	// 체크용 boolean 배열을 사용한 버전
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			boolean[] homework = new boolean[N+1];
			// 과제 낸 사람을 true로 체크하고
			for(int i = 0; i < K; i++) {
				homework[sc.nextInt()] = true;
			}
			
			sb.append("#" + testCase);
			// false인 수들만 출력한다.
			for(int i = 1; i <= N; i++) {
				if(!homework[i]) sb.append(" " + i);
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
