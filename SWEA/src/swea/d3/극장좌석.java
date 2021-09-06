package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 극장좌석 {

	// 빈 좌석이니까 서로 겹칠 수 있다!
	// 1 2 3이 입력으로 들어온다면, □□□●□□□●□□●□ (반대도 가능) 처럼
	// 정렬된 좌석들을 세면 최소값이 된다.
	// 그런데 잘 보니 전체 좌석의 수는 1+2+3 + 3(제일 큰수) + 3(사람수)로도 계산 가능!
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int max = Integer.MIN_VALUE;
			int result = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				int person = Integer.parseInt(st.nextToken());
				result += person;
				if(person > max) max = person;
			}
			
			result += max + N;
			sb.append("#" + testCase + " " + result + "\n");
		}
		System.out.println(sb);
	}

}
