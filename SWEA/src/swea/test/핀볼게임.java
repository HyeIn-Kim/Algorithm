package swea.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 핀볼게임 {

	static class Hole {
		int r;
		int c;
		
		public Hole(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int N;
	static int[][] map;
	static int max;
	// 웜홀의 위치
	static ArrayList<Hole>[] holes;
	// 블록 별 이동위치. {0, 3} 이면 0에서 3으로 이동한다는 뜻
	static int[][][] blocks = {
			{{-1}},
			{{0, 3}, {1, 0}, {2, 1}, {3, 2}},
			{{0, 2}, {1, 3}, {2, 1}, {3, 0}},
			{{0, 1}, {1, 2}, {2, 3}, {3, 0}},
			{{0, 3}, {1, 2}, {2, 0}, {3, 1}},
			{{0, 3}, {1, 2}, {2, 1}, {3, 0}}
	};
	
	// 0 1 2 3 : 상 좌 우 하
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			holes = new ArrayList[5];
			for(int i = 0; i < 5; i++) {
				holes[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					// 웜홀이라면 위치를 저장해둔다.
					if(map[i][j] > 5) {
						holes[map[i][j] - 6].add(new Hole(i, j));
					}
				}
			}
			
			max = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					// 빈칸이라면 핀볼게임 시작!
					if(map[i][j] == 0) {
						for(int d = 0; d < 4; d++) {
							startGame(i, j, i, j, d);
						}
					}
				}
			}
			
			sb.append("#" + testCase + " " + max + "\n");
		}
		System.out.println(sb);
	}

	private static void startGame(int r, int c, int sr, int sc, int d) {
		int score = 0;
		int dir = d;
		
		int nr = r, nc = c;
		while(true) {
			// 이동
			nr += dr[dir];
			nc += dc[dir];
			
			// 벽을 만나면 점수 + 1, 방향 전환
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) {
				score++;
				dir = (3 - dir);
			}
			
			// 시작 위치거나 블랙홀이라면
			else if((nr == sr && nc == sc) || map[nr][nc] == -1) {
				// 현재까지의 점수를 집계하고 게임 종료
				max = Math.max(max, score);
				return;
			}
			
			// 1 ~ 5 번 블록일 때: 점수 + 1, 블록에 따라 뱡향 전환
			else if(1 <= map[nr][nc] && map[nr][nc] <= 5) {
				score++;
				dir = blocks[map[nr][nc]][dir][1];
			}
			
			// 6 ~ 10 번 웜홀일 때: 페어 웜홀로 이동, 방향 유지
			else if(6 <= map[nr][nc] && map[nr][nc] <= 10) {
				int num = map[nr][nc] - 6;
				for(int i = 0; i < 2; i++) {
					if(holes[num].get(i).r != nr
					|| holes[num].get(i).c != nc) {
						nr = holes[num].get(i).r;
						nc = holes[num].get(i).c;
						break;
					}
				}
			}
		}
	}

}
