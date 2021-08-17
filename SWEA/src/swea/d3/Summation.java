package swea.d3;

import java.util.Scanner;

public class Summation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < 10; i++) {
				int N = sc.nextInt();
				int sum = 0;
				while(N > 0) {
					sum += N % 10;
					N /= 10;
				}
				max = Math.max(max, sum);
				min = Math.min(min, sum);
			}
			sb.append("#" + testCase + " " + max + " " + min + "\n");
		}
		System.out.println(sb);

	}

}
