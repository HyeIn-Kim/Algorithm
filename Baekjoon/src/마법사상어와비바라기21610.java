import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 마법사상어와비바라기21610 {

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
	static int[][] move;
	static int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static ArrayList<Node> clouds;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		move = new int[M][2];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; j++) {
				move[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		clouds = new ArrayList<>();
		clouds.add(new Node(N-1, 0));
		clouds.add(new Node(N-1, 1));
		clouds.add(new Node(N-2, 0));
		clouds.add(new Node(N-2, 1));
		
		rainMaker();
		
		int sum = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sum += map[i][j];
			}
		}
		System.out.println(sum);
	}

	private static void rainMaker() {
		for(int i = 0; i < M; i++) {
			// 구름 이동
			moveClouds(i);
			
			// 비내리기 물+1
			rain();
			
			// 물복사버그
			waterCopy();
			
			// 새구름만들기
			makeClouds();
			
		}
	}

	private static void moveClouds(int n) {
		int size = clouds.size();
		int d = move[n][0];
		for(int i = 0; i < size; i++) {
			Node cloud = clouds.get(i);
			// 맵은 연결되어 있으니 N으로 나눈 나머지를 구해준다!
			int nr = (cloud.r + (dr[d] * move[n][1])) % N;
			int nc = (cloud.c + (dc[d] * move[n][1])) % N;
			// 0보다 작으면 양수로 만들어줌
			if(nr < 0) nr += N;
			if(nc < 0) nc += N;
			
			cloud.r = nr;
			cloud.c = nc;
		}
	}

	private static void rain() {
		visited = new boolean[N][N];
		int size = clouds.size();
		for(int i = 0; i < size; i++) {
			Node cloud = clouds.get(i);
			// 구름이 있는 칸에 물을 1 더하고
			map[cloud.r][cloud.c]++;
			// visited를 체크해 주었다 (다음 구름에서 쓸 예정)
			visited[cloud.r][cloud.c] = true;
		}		
	}

	private static void waterCopy() {
		int size = clouds.size();
		for(int i = 0; i < size; i++) {
			Node cloud = clouds.get(i);
			
			int cnt = 0;
			// 대각선 방향을 검사해서
			for(int d = 2; d <= 8; d += 2) {
				int nr = cloud.r + dr[d];
				int nc = cloud.c + dc[d];
				// 범위 벗어나면 pass
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				// 물이 없어도 pass
				if(map[nr][nc] == 0) continue;
				// 물이 있는 칸의 개수를 세고
				cnt++;
			}
			
			// 물이 있는 칸의 개수만큼 더해준다.
			map[cloud.r][cloud.c] += cnt;
		}
	}

	private static void makeClouds() {
		// 현재까지의 구름을 비워주고
		clouds.clear();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				// 구름이었던 칸은 pass
				if(visited[i][j]) continue;
				// 물이 부족해도 pass
				if(map[i][j] < 2) continue;
				
				// 물을 2 줄여주고 구름을 만들자!
				map[i][j] -= 2;
				clouds.add(new Node(i, j));
			}
		}
	}
}
