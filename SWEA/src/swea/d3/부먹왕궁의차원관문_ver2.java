package swea.d3;

import java.util.Scanner;

public class 부먹왕궁의차원관문_ver2 {

	// 수정해도 왜 이렇게 느린가 했더니
	// N이 30만까지여서 입출력 차이인듯 하다..
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();	// 도시 수
			int D = sc.nextInt();	// 제한거리

			int result = 0;
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				// 0이 나오면 카운트 시작
				if(sc.nextInt() == 0) cnt++;
				else cnt = 0;
				
				// D 안에 차원관문이 없으면 하나 세우고
				// 카운트를 0으로 만들어줌
				if(cnt == D) {
					result++;
					cnt = 0;
				}
			}
			
			sb.append("#" + testCase + " " + result + "\n");
		}
		System.out.println(sb);
	}

}
