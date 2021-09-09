package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 입력값은 int 범위를 넘어가지만...
// 홀수인지 짝수인지는 마지막 자리만 보면 알 수 있다.
// 마지막자리 홀수 -> 홀수 / 마지막자리 짝수 -> 짝수
public class 홀수일까짝수일까 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			char[] input = br.readLine().toCharArray();
			
			// 마지막 자리를 숫자로 바꾼 후
			int last = input[input.length-1] - '0';
			// 홀짝을 비교!
			if(last % 2 == 0) sb.append("#" + testCase + " Even\n");
			else sb.append("#" + testCase + " Odd\n");
		}
		System.out.println(sb);
	}

}
