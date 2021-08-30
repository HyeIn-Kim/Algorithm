package swea.d3;

import java.util.Scanner;

public class 문제제목붙이기 {

	//문제를 잘못 이해해서 상당히 헤맸던 문제...
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int[] alpha = new int[26];	// 알파벳이 몇번 나왔는지 셀 배열
			int N = sc.nextInt();
			for(int i = 0; i < N; i++) {
				String input = sc.next();
				// 나온 알파벳 자리를 1 더한다.
				alpha[input.charAt(0) - 'A']++;
			}
			
			int cnt = 0;
			// 연속되는 1의 개수만큼 카운트를 센다.
			for(int i = 0; i < 26; i++) {
				if(alpha[i] == 0) break;
				cnt++;
			}
			sb.append("#" + testCase + " " + cnt + "\n");
		}
		System.out.println(sb);
	}

}
