package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalkinWilfTree {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			int a = 1;
			int b = 1;
			String input = br.readLine();
			for(int i = 0; i < input.length(); i++) {
				int na = 0;
				int nb = 0;
				// 왼쪽은 a / a + b로 이동
				if(input.charAt(i) == 'L') {
					na = a;
					nb = a + b;
				}
				// 오른쪽은 a + b / b로 이동!
				else if(input.charAt(i) == 'R') {
					na = a + b;
					nb = b;
				}
				a = na;
				b = nb;
			}
			sb.append("#" + testCase + " " + a + " " + b + "\n");
		}
		System.out.println(sb);
	}

}
