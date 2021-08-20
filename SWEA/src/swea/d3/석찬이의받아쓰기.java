package swea.d3;

import java.util.Scanner;

public class 석찬이의받아쓰기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			String str = sc.next();
			char[] answer = str.toCharArray();
			str = sc.next();
			char[] input = str.toCharArray();
			
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				if(answer[i] == input[i]) cnt++;
			}
			
			System.out.println("#" + testCase + " " + cnt);
		}

	}

}
