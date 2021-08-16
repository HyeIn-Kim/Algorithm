package swea.d3;

import java.util.Scanner;

public class 코딩토너먼트1 {

	static int boring;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			int[] input = new int[(int)Math.pow(2, N)];
			boring = 0;
			
			for(int i = 0; i < input.length; i++) {
				input[i] = sc.nextInt();
			}
			
			tournament(input);
			sb.append("#" + testCase + " " + boring + "\n");
		}
		System.out.println(sb);
	}
	
	private static void tournament(int[] input) {
		int N = input.length;
		if(N == 1) {
			return;
		}
		
		int[] result = new int[N/2];
		for(int i = 0; i < N/2; i++) {
			result[i] = (input[i*2] > input[(i*2)+1]) ? input[i*2] : input[(i*2)+1];
			boring += Math.abs(input[i*2] - input[(i*2)+1]);
		}
		tournament(result);
	}

}
