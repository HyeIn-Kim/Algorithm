import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 치킨배달15686 {
	
	static class Node {
		int r;
		int c;
		
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M;
	static int[][] map;
	static ArrayList<Node> houses;		// 집 좌표
	static ArrayList<Node> chickens;	// 치킨집 좌표
	static int H, C;					// 각각 집, 치킨집의 총 size
	static int[][] distances;			// 집별로 치킨집과의 치킨 거리를 저장
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		houses = new ArrayList<>();
		chickens = new ArrayList<>();
		
		// 1. 입력받으면서 집과 치킨집의 좌표를 저장한다.
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N;  j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) houses.add(new Node(i, j));
				if(map[i][j] == 2) chickens.add(new Node(i, j));
			}
		}
		
		H = houses.size();
		C = chickens.size();
		distances = new int[H][C];
		// 2. 각 집별로 치킨잡과의 치킨거리를 미리 계산해둔다.
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < C; j++) {
				distances[i][j] = Math.abs(houses.get(i).r - chickens.get(j).r)
						+ Math.abs(houses.get(i).c - chickens.get(j).c);
			}
		}
		
		// 3. 치킨집 C개 중 M개를 남겨두는 조합을 구하고,
		// 도시의 치킨 거리의 최소값을 구한다.
		result = Integer.MAX_VALUE;
		selected = new int[M];
		Combination(0, 0);
		System.out.println(result);
	}

	static int result;
	static int[] selected;
	
	private static void Combination(int cnt, int idx) {
		if(cnt == M) {
			// 각 집별 최소 치킨 거리를 구하고
			int distance = 0;
			for(int i = 0; i < H; i++) {
				int min = Integer.MAX_VALUE;
				for(int j = 0; j < M; j++) {
					min = Math.min(min, distances[i][selected[j]]);						
				}
				
				// 모든 집들의 최소 치킨 거리를 더하자~
				distance += min;
			}
			result = Math.min(result, distance);
			return;
		}
		
		// i+1이 아니라 idx+1로 써놔서
		// 시간초과 때문에 매우 고생했다.
		// 다음칸부터 다시 수를 뽑자!
		for(int i = idx; i < C; i++) {
			selected[cnt] = i;
			Combination(cnt + 1, i + 1);
		}
	}
}