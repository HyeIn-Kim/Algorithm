package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 단순2진암호코드_ver2 {

	static String[] num = {
			"0001101", "0011001", "0010011", "0111101", "0100011",
			"0110001", "0101111", "0111011", "0110111", "0001011"
	};
	
	// 첫번째 시도(08/22): 문자열을 처음부터 읽어서 숫자가 시작하는 부분을 찾고, 연속 8자리 비교
	// 그러나 자꾸 메모리가 초과되는 오류 발생.
	// 두번째 시도(08/22~23): 이번에는 문자열을 뒤에서부터 읽어서 1이 나오는 자리부터 연속 8자리 비교
	// 코드를 찾을 때까지 계속 반복을 돌아서 이번에도 메모리가 초과되었다.
	// 따라서 다른 사람들의 코드를 읽고 새로 짜 본다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 암호 String을 저장할 String 변수
			String codeString = "";
			for(int i = 0; i < N; i++) {
				String input = br.readLine();

				// 맨 뒤에서부터 1을 만날 때까지 검사
				for(int j = M-1; j >= 0; j--) {
					// 처음으로 1을 만나면 암호가 끝나는 지점.
					// 연속 56글자(7자 암호 * 8글자)를 떼어 저장하고 종료한다.
					// 모든 N을 다 돌지 않는 이유는 testCase의 입력값에는 단 하나의 암호코드만 들어있기 때문.
					// 이 점을 간과하지 않고 모든 입력을 다 돌았더니 메모리가 터졌다...
					if(input.charAt(j) == '1') {
						codeString = input.substring(j-55, j+1);
						break;
					}
				}
			}
				
			// 구한 암호코드를 숫자와 매칭시킨다.
			int[] code = new int[8];
			int cnt = 0;
			for(int i = 0; i < 56; i+=7) {
				int value = findNum(codeString.substring(i, i+7));
				if(value != -1) {
					code[cnt] = value;
					cnt++;
				}
			}
			
			// 암호 검증 + sum값 미리 구해놓기
			int odd = 0, even = 0;
			int sum = 0;
			for(int i = 0; i < 8; i++) {
				if(i % 2 == 0) odd += code[i];
				else if(i % 2 == 1 && i != 7) even += code[i];
				sum += code[i];
			}
			
			// 올바른 암호라면 sum을, 아니라면 0을 출력한다.
			int result = (odd * 3) + even + code[7];
			System.out.println("#" + testCase + " " + ((result % 10 == 0) ? sum : 0));
		}
	}
	
	private static int findNum(String in) {
		for(int i = 0; i < 10; i++) {
			if(num[i].equals(in)) return i;
		}
		return -1;
	}

}
