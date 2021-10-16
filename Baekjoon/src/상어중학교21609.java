import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 상어중학교21609 {

	static class Node {
		int r;
		int c;
		
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static class BlockGroup implements Comparable<BlockGroup>{
		int r, c;		// 기준 블록의 r, c
		int size;		// 블록 그룹 크기
		int rainbow;	// 무지개블록 개수
		
		public BlockGroup(int r, int c, int size, int rainbow) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
			this.rainbow = rainbow;
		}

		@Override
		public int compareTo(BlockGroup o) {
			if(this.size == o.size) {
				if(this.rainbow == o.rainbow) {
					if(this.r == o.r) {
						return o.c - this.c;
					}
					else return o.r - this.r;
				}
				else return o.rainbow - this.rainbow;
			}
			else return o.size - this.size;
		}
	}
	
	static int N, M;
	static int[][] map;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	static boolean[][] visited;
	static PriorityQueue<BlockGroup> blockGroups;
	static final int REMOVED_BLOCK = -2;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 맵 입력
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		result = 0;
		while(true) {
			// 블록 그룹 만들기
			makeBlockGroups();
			
			// 만약 블록그룹이 존재하지 않는다면 break
			if(blockGroups.size() == 0) break;
			
			// 존재한다면 게임 1 ~ 5단계 실행
			autoPlay();
		}
		
		System.out.println(result);
	}

	private static void makeBlockGroups() {
		blockGroups = new PriorityQueue<>();
		visited = new boolean[N][N];
		
		// i, j 순서대로 돌면서 일반 블록을 찾아 블록 그룹을 구성하면
		// (i, j)가 기준 블록이 됨
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(1 <= map[i][j] && map[i][j] <= M) {
					BFS(i, j);
				}
			}
		}
	}

	private static void BFS(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c));
		visited[r][c] = true;
		
		int color = map[r][c];		// 블록 그룹 색상
		int size = 0;				// 블록 그룹 크기
		int rainbow = 0;			// 무지개 블록 개수
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			size++;
			
			for(int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				
				// 범위를 벗어나면 pass
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				// 이미 방문한 곳은 블록 그룹이 만들어졌으므로 pass
				if(visited[nr][nc]) continue;
				// 무지개 블록이 아니거나, 같은 색이 아니라면 pass
				if(map[nr][nc] != 0 && map[nr][nc] != color) continue;
				
				// 무지개 블록이라면 개수를 더해줌
				if(map[nr][nc] == 0) {
					rainbow++;
				}
				
				// 큐에 넣기, 방문체크
				queue.offer(new Node(nr, nc));
				visited[nr][nc] = true;
			}
		}
		
		// BFS를 다 돌고 나면 블록 그룹이 만들어진다.
		// 크기가 1이라면 블록 그룹을 만들 수 없으므로 방문 체크를 풀어줌
		if(size == 1) {
			visited[r][c] = false;
			return;
		}
		
		// 무지개블록 방문체크 해제
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0) visited[i][j] = false;
			}
		}
		
		blockGroups.add(new BlockGroup(r, c, size, rainbow));
	}

	private static void autoPlay() {
		// 1. 블록 그룹 찾기: PQ Comparable 조건에 맞게 꺼내줌
		BlockGroup blockGroup = blockGroups.poll();
		
		// 2. 블록 그룹을 돌면서 제거함
		removeBlocks(blockGroup.r, blockGroup.c);
		result += (blockGroup.size * blockGroup.size);
		
		// 3. 중력 작용
		gravity();
		// 4. 90도 반시계방향 회전
		rotate();
		// 5. 중력 작용
		gravity();
	}
	
	private static void removeBlocks(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c));
		int color = map[r][c];				// 블록 그룹 색상
		map[r][c] = REMOVED_BLOCK;			// 블록 삭제
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nr = n.r + dr[d];
				int nc = n.c + dc[d];
				
				// 범위를 벗어나면 pass
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				// 무지개 블록이 아니거나, 같은 색이 아니라면 pass
				if(map[nr][nc] != 0 && map[nr][nc] != color) continue;
								
				// 큐에 넣기, 블록 삭제(= 방문체크)
				queue.offer(new Node(nr, nc));
				map[nr][nc] = REMOVED_BLOCK;
			}
		}
	}

	private static void gravity() {
		for(int r = N-2; r >= 0; r--) {
			for(int c = 0; c < N; c++) {
				// 현재 칸이 블록이고 다음 칸이 빈 칸이라면
				if(0 <= map[r][c] && map[r+1][c] == REMOVED_BLOCK) {
					int nr = r, nb = r + 1;
					
					// 바닥이나 검은 블록이 나올 때까지 1칸씩 밑으로 땡겨준다!
					while(nb < N && map[nb][c] == REMOVED_BLOCK) {
						int temp = map[nr][c];
						map[nr][c] = map[nb][c];
						map[nb][c] = temp;
						nr++;
						nb++;
					}
				}
			}
		}
	}

	private static void rotate() {
		int[][] copyMap = new int[N][N];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				copyMap[N-1-c][r] = map[r][c];
			}
		}
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				map[r][c] = copyMap[r][c];
			}
		}
	}
}
