package swea.d3;

import java.util.Scanner;

public class String_ {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int T = 1; T <= 10; T++) {
			int N = sc.nextInt();
			String a = sc.next();	// 문자열
			String b = sc.next();	// 문자열을 찾을 문장
			
			int cnt = 0;
			// b 안에 a가 몇번 들어가있는지 센다.
			for(int i = 0; i < b.length() - a.length() + 1; i++) {
				boolean isSame = true;
				for(int j = 0; j < a.length(); j++) {
					// 쭉 비교하다가 같지 않다면 종료
					if(b.charAt(i + j) != a.charAt(j)) {
						isSame = false;
						break;
					}
				}
				
				// for문이 끝나도 true라면 같은 문자열. cnt를 +1한다.
				if(isSame) cnt++;				
			}
			
			System.out.println("#" + T + " " + cnt);
		}

	}

}
