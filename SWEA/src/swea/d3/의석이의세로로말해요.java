package swea.d3;

import java.util.Scanner;

public class 의석이의세로로말해요 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			// 5개의 입력을 String 배열에 넣어서
			// 글자가 있다면 세로로 쭉 읽게 했다.
			String[] words = new String[5];
			for(int i = 0; i < 5; i++) {
				words[i] = sc.next();
			}
			
			sb.append("#" + testCase + " ");
			for(int i = 0; i < 15; i++) {
				for(int j = 0; j < 5; j++) {
					if(i < words[j].length())
						sb.append(words[j].charAt(i));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
