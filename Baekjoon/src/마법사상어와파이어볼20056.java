import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 기존 코드에서 파이어볼을 더할 때,
// O(1)으로 (r, c)에 바로 접근하지 않고 계속 리스트를 돌면서 찾았던 게
// 시간초과의 원인이 아닐까 한다... (사실 그 외에도 입력, 속도계산 등등 더 틀렸음)
public class 마법사상어와파이어볼20056 {

	static class Node {
		int m;
		int s;
		int d;
		
		public Node(int m, int s, int d) {
			super();
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	static int N, M, K;
	static LinkedList<Node>[][] map;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// LinkedList 초기화
		// map이 연결되므로 1~N이 아니라 계산의 편의를 위해 0~N-1로 잡았다.
		map = new LinkedList[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = new LinkedList<>();
			}
		}
		
		// 입력: 맵 범위가 0~N-1이기 때문에 r, c도 1씩 빼준다.
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[r][c].add(new Node(m, s, d));
		}
		
		for(int i = 0; i < K; i++) {
			// 파이어볼 이동
			moveBalls();

			// 파이어볼 나누기
			divideBalls();
		}
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(Node n : map[i][j]) {
					cnt += n.m;
				}
			}
		}
		System.out.println(cnt);
	}

	private static void moveBalls() {
		// next: 이동 후의 파이어볼이 들어간다.
		LinkedList<Node>[][] next = new LinkedList[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				next[i][j] = new LinkedList<>();
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				for (Node n : map[r][c]) {
					// 각 노드를 이동시켜주자!
					// 속력이 1000까지이므로 N으로 나눠주는거 잊지 말기!
					int nr = (r + ((n.s % N) * dr[n.d]) + N) % N;
					int nc = (c + ((n.s % N) * dc[n.d]) + N) % N;

					next[nr][nc].add(n);
				}
			}
		}
		
		// 이동을 다 했다면 map에 next를 참조시킴
		map = next;
	}

	private static void divideBalls() {
		// 모든 칸에 대하여
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				// 파이어볼이 2개 이상일 때만
				if(map[r][c].size() <= 1) continue;
				
				int m = 0, s = 0;						// 질량, 속력의 합
				boolean isEven = true, isOdd = true;	// 홀짝 판단
				// 모든 파이어볼들의 질량, 속력, 방향을 합해준다.
				for(Node n : map[r][c]) {
					m += n.m;
					s += n.s;
					if(n.d % 2 == 0) isOdd = false;
					else isEven = false;
				}
				
				// 파이어볼이 나눠지면 원래 있던 파이어볼은 사라지므로 칸 초기화를 해주었다.
				m /= 5;
				s /= map[r][c].size();
				map[r][c].clear();
				
				// 파이어볼 질량이 0이 아니라면 맵에 파이어볼 4개를 추가한다!
				if(m > 0) {
					for(int d = (isEven || isOdd) ? 0 : 1; d < 8; d += 2) {
						map[r][c].add(new Node(m, s, d));
					}
				}
			}
		}
	}
}