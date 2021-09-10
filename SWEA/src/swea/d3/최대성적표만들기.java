package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최대성적표만들기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] input = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			// K개의 최댓값... 아하! 가장 큰 수 3개를 더하면 되는구나!
			// 정렬을 해서 맨 뒤부터 K개를 넣으면 되겠다!
			Arrays.sort(input);
			int sum = 0;
			for(int i = N-1; i >= N-K; i--) {
				sum += input[i];
			}
			sb.append("#" + testCase + " " + sum + "\n");
		}
		System.out.println(sb);
	}

}
