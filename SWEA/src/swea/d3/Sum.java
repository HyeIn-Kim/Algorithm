package swea.d3;

import java.util.Scanner;

// 반복문 4개 쓰기 귀찮아서 하나에 때려박았는데
// 가독성은 4개 쓰는게 훨~~~~~~~~씬 좋은 것 같다.
public class Sum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1; testCase <= 10; testCase++) {
			int T = sc.nextInt();
			int[][] map = new int[100][100];
			
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int max = 0;
			int sumLeftD = 0;	// Left Digonal. 왼쪽 대각선
			int sumRightD = 0;	// Right Digonal. 오른쪽 대각선
			for(int i = 0; i < 100; i++) {
				int sumR = 0;
				int sumC = 0;
				for(int j = 0; j < 100; j++) {
					sumC += map[i][j];
					// i와 j를 거꾸로 써서 세로 합을 구함
					sumR += map[j][i];
					// 1,1 2,2 처럼 i랑 j가 같으면 왼쪽대각선
					if(i == j) sumLeftD += map[i][j];
					// 오른쪽 대각선 0,100 1,99... 는 i+j의 합이 100이다.
					if(i + j == 100) sumRightD += map[i][j];
				}
				if(sumC > max) max = sumC;
				if(sumR > max) max = sumR;
			}
			
			if(sumLeftD > max) max = sumLeftD;
			if(sumRightD > max) max = sumRightD;
			sb.append("#" + testCase + " " + max + "\n");
		}
		System.out.println(sb);
	}

}
