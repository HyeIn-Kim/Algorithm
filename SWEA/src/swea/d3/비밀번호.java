package swea.d3;

import java.util.Scanner;

public class 비밀번호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int T = 1; T <= 10; T++) {	
			int N = sc.nextInt();
			String str = sc.next();
			
			int i = 1;
			while(true) {
				// 같은 문자가 있을 때까지 i를 증가시킨다.
				while((i < N) && (str.charAt(i-1) != str.charAt(i))) i++;
				if(i >= N) break;
				
				char[] ch = {str.charAt(i-1), str.charAt(i)};
				String value = new String(ch);
				// 같은 문자들을 없애고 문자열 끝까지 반복한다.
				str = str.replace(value, "");
				N = str.length();
				i = 1;
			}
			
			sb.append("#" + T + " " + str + "\n");
		}
		System.out.println(sb);
	}

}
