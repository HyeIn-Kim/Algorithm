package swea.d3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 안경이없어 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		// 구멍 0개인 알파벳
		ArrayList<Character> zero = new ArrayList<>(Arrays.asList('C', 'E', 'F', 'G', 'H',
																		'I', 'J', 'K', 'L', 'M',
																		'N', 'S', 'T', 'U', 'V',
																		'W', 'X', 'Y', 'Z'));
		// 구멍 1개인 알파벳
		ArrayList<Character> one = new ArrayList<>(Arrays.asList('A', 'D', 'O', 'P', 'Q', 'R'));
		for(int testCase = 1; testCase <= T; testCase++) {
			String a = sc.next();
			String b = sc.next();
			boolean isSame = true;
			
			// 문자열 A와 B의 길이가 같지 않다면 다르니까 DIFF 출력하고 다음 tc로 넘어감
			if(a.length() != b.length()) {
				sb.append("#" + testCase + " DIFF\n");
				continue;
			}
			
			int length = a.length();
			for(int i = 0; i < length; i++) {
				// 알파벳의 구멍 수가 같으면 continue,
				// 다르다면 isSame을 false로 바꾸고 break한다.
				if(zero.contains(a.charAt(i)) && zero.contains(b.charAt(i))
					|| one.contains(a.charAt(i)) && one.contains(b.charAt(i))
					|| a.charAt(i) == 'B' && b.charAt(i) == 'B') continue;
				isSame = false;
				break;
			}
			
			// 결과값에 따라서 같은지 다른지 여부를 출력한다.
			if(isSame) sb.append("#" + testCase + " SAME\n");
			else sb.append("#" + testCase + " DIFF\n");
		}
		System.out.println(sb);

	}

}
