package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 적고지우기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			String input = br.readLine();
			int N = input.length();
			// 0부터 9까지 적혀있으면 true, 지워졌으면 false
			boolean[] isWritten = new boolean[10];
			for(int i = 0; i < N; i++) {
				int value = input.charAt(i) - '0';
				isWritten[value] = (isWritten[value]) ? false : true;
			}
			
			// true이면 적혀있으므로 true인 숫자들만 세서 출력한다!
			int cnt = 0;
			for(int i = 0; i < 10; i++) {
				if(isWritten[i]) cnt++;
			}
			sb.append("#" + testCase + " " + cnt + "\n");
		}
		System.out.println(sb);
	}

}
