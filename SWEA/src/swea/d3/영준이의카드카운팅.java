package swea.d3;

import java.util.Scanner;

public class 영준이의카드카운팅 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			String input = sc.next();
			int[][] cnt = new int[4][14];	// 각 종류별로 카드가 몇장 있는지 센다.
			boolean isError = false;		// 중복을 확인할 boolean 변수
			for(int i = 0; i < input.length(); i += 3) {
				char s = input.charAt(i);
				int shape = 0;
				int num = Integer.parseInt(input.substring(i+1, i+3));
				if(s == 'S') shape = 0;
				else if(s == 'D') shape = 1;
				else if(s == 'H') shape = 2;
				else if(s == 'C') shape = 3;
				
				// 중복되는 카드가 들어있다면 에러
				if(cnt[shape][num] != 0) isError = true;
				else cnt[shape][num]++;
			}
			
			// 에러이면 남은 카드를 세지 않고 끝
			// 에러가 아닐 경우, 모양별 몇장 남았는지 세서 출력한다.
			if(isError) sb.append("#" + testCase + " ERROR\n");
			else {
				sb.append("#" + testCase);
				for(int i = 0; i < 4; i++) {
					int leftCard = 13;
					for(int j = 1; j < 14; j++) {
						if(cnt[i][j] == 1) leftCard--;
					}
					sb.append(" " + leftCard);
				}
				sb.append("\n");
			}
			
		}

		System.out.println(sb);
	}

}
