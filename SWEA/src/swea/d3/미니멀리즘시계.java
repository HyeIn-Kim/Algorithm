package swea.d3;

import java.util.Scanner;

public class 미니멀리즘시계 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int angle = sc.nextInt();
			int hour = (angle / 30) % 12;
			int minute = (angle % 30) * 2;
			
			// StringBuilder + println 썼다가 오류나서 3시간 잡아먹음... 조심하자!
			System.out.printf("#%d %d %d\n", testCase, hour, minute);
		}
	}

}
