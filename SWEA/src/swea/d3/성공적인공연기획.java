package swea.d3;

import java.util.Scanner;

public class 성공적인공연기획 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			String input = sc.next();
			int cnt = 0;	// 섭외해야 하는 사람 수
			int sum = 0;	// 박수를 치는 전체 사람 수
			for(int i = 0; i < input.length(); i++) {
				// 박수를 쳐야 하는데 사람수가 모자라다면
				if(input.charAt(i) != '0' && i > sum) {
					cnt += i - sum;	// 박수를 칠때까지 사람 섭외
					sum += i - sum;	// ↑ 이사람들을 전체인원에 더해줌
				}
				sum += input.charAt(i) - '0';	// 박수친 사람을 더해줌
			}
			sb.append("#" + testCase + " " + cnt + "\n");
		}
		System.out.println(sb);
	}

}
