package swea.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미생물격리 {

	static class Node {
		int r;
		int c;
		int cnt;
		int move;
		int maxCnt;
		
		public Node(int r, int c, int cnt, int move, int maxCnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.move = move;
			this.maxCnt = maxCnt;
		}
	}
	
	static int N, M, K;
	static boolean[][] visited;
	static Queue<Node> germs;
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, -1, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			// 미생물 입력
			germs = new LinkedList<>();
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int move = Integer.parseInt(st.nextToken());
				
				germs.offer(new Node(r, c, cnt, move, cnt));
			}
			
			// M시간동안 이동
			for(int i = 0; i < M; i++) {
				move();
			}
			
			int result = 0;
			while(!germs.isEmpty()) {
				Node n = germs.poll();
				result += n.cnt;
			}
			
			sb.append("#" + testCase + " " + result + "\n");
		}
		System.out.println(sb);
	}
	
	private static void move() {
		// 방문 배열
		visited = new boolean[N][N];
		// 이동한 뒤 남아있는 군집을 저장할 list
		ArrayList<Node> add = new ArrayList<>();
		
		while(!germs.isEmpty()) {
			Node n = germs.poll();
			
			int nr = n.r + dr[n.move];
			int nc = n.c + dc[n.move];
			
			// 약품에 닿았을 때
			if(nr == 0 || nc == 0 || nr == N-1 || nc == N-1) {
				// 미생물 개수를 반으로 줄이고
				n.cnt = n.cnt / 2;
				n.maxCnt = n.cnt;
				// 0개라면 pass
				if(n.cnt == 0) continue;
				// 방향을 반대로 전환한다.
				n.move = getDirection(n.move);
			}
			
			// 다른 군집과 같은 위치에 있을 때
			else if(visited[nr][nc]) {
				int size = add.size();
				// 남아 있는 군집을 돌면서
				for(int j = 0; j < size; j++) {
					Node m = add.get(j);
					// 나와 같은 좌표의 군집이라면
					if(nr == m.r && nc == m.c) {
						// 미생물을 더해주고
						m.cnt += n.cnt;
						// 큰 값에 따라 움직임을 갱신한다.
						if(n.maxCnt > m.maxCnt) {
							m.maxCnt = n.maxCnt;
							m.move = n.move;
						}
						break;
					}
				}
				// 중복이므로 pass
				continue;
			}
		
			// 방문처리, 군집을 남겨둔다.
			visited[nr][nc] = true;
			add.add(new Node(nr, nc, n.cnt, n.move, n.maxCnt));
		}
		
		// 살아있는 군집을 큐에 다시 넣자!
		for(Node n : add) {
			germs.offer(new Node(n.r, n.c, n.cnt, n.move, n.cnt));
		}
	}

	// 약품에 닿았을 때 방향을 바꿔주는 함수
	private static int getDirection(int move) {
		int result = 0;
		
		switch(move) {
		case 1: result = 2; break;
		case 2: result = 1; break;
		case 3: result = 4; break;
		case 4: result = 3; break;
		}
		
		return result;
	}

}
