package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// C언어적 접근이 너무 심하다.
// java에서는 char형에 숫자덧셈을 하면 ascii 코드가 아니라 int형이 되어버린다..
// 결국 Character.toUpperCase()를 사용했다.
// 처음에 띄어쓰기 검사도 반복문으로 하려고 했는데
// split으로 나누면 되는 거였다. 맙소사..
public class 두문자어 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			String[] input = br.readLine().split(" ");
			
			sb.append("#" + testCase + " ");
			for(int i = 0; i < input.length; i++) {
				sb.append(Character.toUpperCase(input[i].charAt(0)));
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
