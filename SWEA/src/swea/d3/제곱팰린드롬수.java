package swea.d3;

import java.util.Scanner;

public class 제곱팰린드롬수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int cnt = 0;
			for(int i = A; i <= B; i++) {
				double sqrt = Math.sqrt(i);
				if(sqrt % 1 == 0) {
					if(isPalindrome(Integer.toString((int)sqrt))) {
						if(isPalindrome(Integer.toString(i)))
							cnt++;
					}
				}
			}
			
			System.out.println("#" + testCase + " " + cnt);
		}

	}
	
	private static boolean isPalindrome(String s) {
		int N = s.length();
		for(int i = 0; i < N/2; i++) {
			if(s.charAt(i) != s.charAt(N - i - 1))
				return false;
		}
		return true;
	}

}
