package swea.d3;

import java.util.Scanner;

public class 소득불균형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int sum = 0;
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			
			int cnt = 0;
			double avg = (double)sum / N;
			for(int i = 0; i < N; i++) {
				if(arr[i] <= avg)
					cnt++;
			}
			
			System.out.println("#" + testCase + " " + cnt);
		}

	}

}
