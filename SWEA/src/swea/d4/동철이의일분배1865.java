package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가지치기가 생명!!
// 확률을 계속 곱해가니까 한번 max보다 작아지면 더는 볼 필요가 없어짐.
public class 동철이의일분배1865 {

	static int N;
	static double[][] input;
	static boolean[] selected;
	static double max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			if(testCase == 2) { 
				int a = 1;
			}
			N = Integer.parseInt(br.readLine());
			input = new double[N][N];
			StringTokenizer st = null;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					input[i][j] = Double.parseDouble(st.nextToken()) * 0.01;
				}
			}
			
			max = 0;
			selected = new boolean[N];
			// 곱하기니까 초기값을 1로 해줘야 한다!
			permutation(0, 1);
			sb.append(String.format("#%d %.6f\n", testCase, max * 100));
		}
		System.out.println(sb.toString());
	}

	// 순열로 구했다. cnt = 지금까지 뽑은 개수 / sum = 현재까지의 확률
	private static void permutation(int cnt, double sum) {
		// 현재까지의 확률이 max보다 낮거나 같아지면 return (가지치기)
		if(sum <= max) return;
		
		// 기저조건. sum과 비교해서 max를 갱신해준다.
		if(cnt == N) {
			max = Math.max(max, sum);
			return;
		}
		
		// 순열 뽑는 코드
		for(int i = 0; i < N; i++) {
			if(selected[i]) continue;
			
			selected[i] = true;
			permutation(cnt + 1, sum * input[i][cnt]);
			selected[i] = false;
		}
	}

}
