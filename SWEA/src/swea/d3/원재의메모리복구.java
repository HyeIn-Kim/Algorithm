package swea.d3;

import java.util.Scanner;

public class 원재의메모리복구 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			// 입력
			String str = sc.next();
			char[] ch = str.toCharArray();
			int[] arr = new int[ch.length];
			int[] memory = new int[ch.length];
			for(int i = 0; i < arr.length; i++) {
				arr[i] = ch[i] - '0';
				memory[i] = 0;
			}
			
			int cnt = 0;
			for(int i = 0; i < arr.length; i++) {
				if(memory[i] != arr[i]) {
					for(int j = i; j < arr.length; j++) {
						memory[j] = (memory[j] == 0) ? 1 : 0;
					}
					cnt++;
				}
			}
			
			sb.append("#" + testCase + " " + cnt + "\n");
		}
		System.out.println(sb);
	}

}
