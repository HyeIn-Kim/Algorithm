package swea.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 홈방범서비스 {

	static class Node {
		int r;
		int c;
		
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M, H;
	static int[][] map;
	static ArrayList<Node> houses;		// 집 좌표 저장
	static int[][][] dist;				// 집 별 모든 좌표의 거리를 구한다.
	static int[] cost;					// K에 따른 비용을 저장
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			houses = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					// 집일 경우, list에 집 좌표만 따로 저장해둔다.
					if(map[i][j] == 1) houses.add(new Node(i, j));
				}
			}
			
			H = houses.size();
			dist = new int[N][N][H];
			// 각 집마다
			for(int h = 0; h < H; h++) {
				// 모든 점에 대해서
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						// 거리를 구해둔다.
						dist[i][j][h] = Math.abs(i - houses.get(h).r) + Math.abs(j - houses.get(h).c);
					}
				}
			}
			
			// 공식에 따라 K의 비용을 미리 구해둔다.
			// 여기서 주의할 점은 문제의 K 범위가 점 사이의 거리보다 1씩 작다.
			// 이걸 틀린 다음에 알아가지고... 좀더 깔끔하게 짤 수 있었을 것도 같은데
			// 일단은 급하게 cost를 K+1만큼으로 잡아서 구했다... 
			cost = new int[N + 3];
			for(int i = 1; i <= N + 2; i++) {
				cost[i] = (i * i) + ((i-1) * (i-1));
			}
			
			int max = 0;
			// 각 점마다
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					// 최대 몇 개를 서비스할 수 있는지 구해보고
					int cnt = getHouses(i, j);
					// 가장 큰 값을 찾는다!
					max = Math.max(max, cnt);
				}
			}
			sb.append("#" + testCase + " " + max + "\n");
		}
		System.out.println(sb);
	}

	private static int getHouses(int r, int c) {
		int max = 0;
		// 모든 K 범위만큼 해보면서
		for(int k = 0; k <= N + 1; k++) {
			int cnt = 0;
			// 각 집이 K 범위 안에 들어올 수 있다면 센다.
			for(int h = 0; h < H; h++) {
				if(dist[r][c][h] <= k) cnt++;
			}
			
			// 손해를 보지 않는다면(= 같거나 이익이라면) 최대값을 갱신해주자!
			if(cnt * M >= cost[k+1]) {
				max = Math.max(max, cnt);		
			}
		}
		
		// return값 max는
		// 현재 좌표에서 최대 몇 집이 서비스받는지이다.
		return max;
	}

}
