package swea.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS를 사용하여 구현하였다.
// 세포 번식 때, 가장 생명력이 긴 세포를 먼저 놓기 위해서 PQ + Comparable을 사용하였다.
public class 줄기세포배양 {

	static class Node implements Comparable<Node> {
		int r;
		int c;
		int life;
		int st;

		public Node(int r, int c, int life, int st) {
			super();
			this.r = r;
			this.c = c;
			this.life = life;
			this.st = st;
		}

		// 큐에서 꺼낼 때 가장 생명력이 긴 세포 먼저 나오도록 오버라이딩함!
		@Override
		public int compareTo(Node o) {
			return o.life - this.life;
		}
	}
	
	// 맵은 적당히 큰 사이즈로 잡아주었다.
	static final int SIZE = 1500;
	static PriorityQueue<Node> cells;
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {-1, 0, 1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] map = new int[SIZE][SIZE];
			// PQ를 초기화하고
			cells = new PriorityQueue<>();
			
			for(int i = 500; i < 500 + N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 500; j < 500 + M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					// 세포가 있다면 PQ에 집어넣었다.
					if(map[i][j] != 0) cells.offer(new Node(i, j, map[i][j], 0));
				}
			}
			
			int cnt = 1;								// BFS의 level
			int result = 0;
			Queue<Node> alive = new LinkedList<>();		// 살아있는 세포를 저장할 큐
			
			while(!cells.isEmpty()) {
				int size = cells.size();
				for(int s = 0; s < size; s++) {
					Node n = cells.poll();
					
					// X시간 후 활성 + 활성 후 첫 1시간
					// 번식할 수 있는 상태이므로 상하좌우로 번식한다.
					if((n.st + (n.life + 1)) == cnt) {
						for(int d = 0; d < 4; d++) {
							int nr = n.r + dr[d];
							int nc = n.c + dc[d];
							// PQ에서 꺼냈으므로 무조건 생명이 긴 세포가 된다.
							// 따라서 세포가 놓여있지 않을 때 번식시켜주면 끝!
							if(map[nr][nc] == 0) {
								map[nr][nc] = n.life;
								alive.offer(new Node(nr, nc, n.life, cnt));
							}
						}
					}
					
					// 세포가 아직 살아있다면 alive 큐에 집어넣음
					if(n.st + (n.life * 2) > cnt) {
						alive.offer(new Node(n.r, n.c, n.life, n.st));
					}
				}
				
				// K시간째일 때 살아있는 세포라면 결과값에 더해주고 종료!
				if(cnt == K) {
					result = alive.size();
					break;
				}

				// 살아있는 세포들을 다시 PQ에 넣어준다.
				while(!alive.isEmpty()) {
					Node n = alive.poll();
					cells.offer(n);
				}
				cnt++;
			}
			
			sb.append("#" + testCase + " " + result + "\n");
		}
		
		System.out.println(sb);
	}

}
