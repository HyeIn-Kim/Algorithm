package swea.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 특이한자석 {

	// 자석의 극(0, 1) 정보를 저장하는 ArrayList 배열 magnet
	// 시계방향/반시계방향 넣고빼기 쉽게 하려고 ArrayList를 사용하였다.
	static ArrayList<Integer>[] magnet;
	// 방문체크용 visited 배열
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			int K = Integer.parseInt(br.readLine());
			
			// 자석 번호는 1, 2, 3, 4 지만 점수 공식이 2의 지수(2^0 = 1, 2^1 = 2, ...)인 점을 감안하여
			// 점수 합산을 편하게 하기 위해 일부러 0부터 배열을 시작하였다.
			magnet = new ArrayList[4];
			for(int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				magnet[i] = new ArrayList<Integer>();
				for(int j = 0; j < 8; j++) {
					magnet[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			
			for(int i = 0; i < K; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				// 입력값은 1~4, 자석 번호는 0~3이므로 1을 빼준다.
				int idx = Integer.parseInt(st.nextToken()) - 1;
				int direction = Integer.parseInt(st.nextToken());
				visited = new boolean[4];	// 1번 돌릴 때마다 필요해서 방문 배열을 매번 새로 만들어 주었다.
				rotateMagnet(idx, direction);	// 자석 회전!
			}
			
			// 실수했던 곳 1. 점수는 K번 회전 후 최종 합산한다!!
			int result = 0;
			for(int i = 0; i < 4; i++) {
				// S극이라면 2^i만큼 점수를 더해준다!
				if(magnet[i].get(0) == 1) result += Math.pow(2, i);
			}
			sb.append("#" + testCase + " " + result + "\n");
		}
		System.out.println(sb);
	}

	// 실수했던 곳 2. 회전 후 극을 검사하는 게 아니라
	// 회전하기 전에 미리 검사하고 회전 가능한 자석만 회전한다!
	private static void rotateMagnet(int idx, int direction) {
		visited[idx] = true;		// 회전 가능 표시
		
		// 내 왼쪽 자석을 회전할 수 있다면 DFS
		if(idx - 1 >= 0 && magnet[idx-1].get(2) != magnet[idx].get(6) && !visited[idx-1]) {
			rotateMagnet(idx - 1, -direction);
		}
		
		// 내 오른쪽 자석을 회전할 수 있다면 DFS
		if(idx + 1 < 4 && magnet[idx].get(2) != magnet[idx+1].get(6) && !visited[idx+1]) {
			rotateMagnet(idx + 1, -direction);
		}
		
		// 여기까지 실행되고 나면 더는 회전 불가능할 때까지 재귀를 타고 들어간 상태이다.
		// 그래서 재귀에서 돌아올 때 회전까지 시켜버리기로 했다!!
		
		// 1이면 시계방향으로 회전하고
		if(direction == 1) {
			int m = magnet[idx].get(7);
			magnet[idx].remove(7);
			magnet[idx].add(0, m);
		}
		// -1이면 반시계방향으로 회전시켰다.
		else if(direction == -1) {
			int m = magnet[idx].get(0);
			magnet[idx].remove(0);
			magnet[idx].add(m);
		}
	}
}
