import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 엄청 쉬운 문제인데 틀렸다.
// 로직은 맞고 블럭이 틀렸다.. 이렇게 억울할수가
// 하나는 회전대칭블럭 1개를 생각 못해서고
// 다른 하나는 종이에 블럭 적어놓고 옮기는 과정에서 빼먹음
public class 테트로미노14500 {

	static int N, M, B;
	static int[][] map;
	static int result;
	// 가능한 블럭 19개 좌표를 다 적고
	static int[][][] block = {
			{{0, 0}, {0, 1}, {0, 2}, {0, 3}},
			{{0, 0}, {1, 0}, {2, 0}, {3, 0}},
			
			{{0, 0}, {0, 1}, {1, 0}, {1, 1}},
			
			{{0, 0}, {1, 0}, {2, 0}, {2, 1}},
			{{0, 0}, {0, 1}, {0, 2}, {1, 0}},
			{{0, 0}, {0, 1}, {1, 1}, {2, 1}},
			{{0, 0}, {0, 1}, {0, 2}, {-1, 2}},
			{{0, 0}, {0, 1}, {1, 0}, {2, 0}},
			{{0, 0}, {0, 1}, {-1, 1}, {-2, 1}},
			{{0, 0}, {0, 1}, {0, 2}, {1, 2}},
			{{0, 0}, {0, 1}, {0, 2}, {1, 0}},
			{{0, 0}, {1, 0}, {1, 1}, {1, 2}},
			
			{{0, 0}, {1, 0}, {1, 1}, {2, 1}},
			{{0, 0}, {0, 1}, {-1, 1}, {-1, 2}},
			{{0, 0}, {0, 1}, {-1, 1}, {1, 0}},
			{{0, 0}, {0, 1}, {1, 1}, {1, 2}},
			
			{{0, 0}, {0, 1}, {0, 2}, {1, 1}},
			{{0, 0}, {1, 0}, {2, 0}, {1, -1}},
			{{0, 0}, {0, 1}, {0, 2}, {-1, 1}},
			{{0, 0}, {1, 0}, {2, 0}, {1, 1}}
	};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		B = block.length;
		result = 0;
		// 각 칸마다 모든 테트로미노를 놓아보자!
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				tetromino(i, j);
			}
		}
		
		System.out.println(result);
	}

	private static void tetromino(int r, int c) {
		// 모든 블럭을
		for(int b = 0; b < B; b++) {
			int sum = 0;
			// 놓아보고
			for(int d = 0; d < 4; d++) {
				int nr = r + block[b][d][0];
				int nc = c + block[b][d][1];
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) break;
				sum += map[nr][nc];
			}
			// 최대값을 찾으면 끝!!
			result = Math.max(result, sum);
		}
	}
}
