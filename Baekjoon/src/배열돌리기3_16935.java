import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배열돌리기3_16935 {

	static int N, M, R;
	static int[][] map;
	static int[] op;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		// 배열 입력
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 연산자 입력
		op = new int[R];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < R; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		// 연산 R회
		for(int r = 0; r < R; r++) {
			switch(op[r]) {
			case 1: op1(); break;
			case 2: op2(); break;
			case 3: op3(); break;
			case 4: op4(); break;
			case 5: op5(); break;
			case 6: op6(); break;
			}
		}
		
		// 출력
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	// 연산 1. 상하반전
	// N/2까지 값을 바꿔주면 된다!
	private static void op1() {
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < M; j++) {
				int temp = map[i][j];
				map[i][j] = map[N-1-i][j];
				map[N-1-i][j] = temp;
			}
		}
	}

	// 연산 2. 좌우반전
	// M/2까지 값을 바꿔주면 된다!
	private static void op2() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M/2; j++) {
				int temp = map[i][j];
				map[i][j] = map[i][M-1-j];
				map[i][M-1-j] = temp;
			}
		}
	}

	// 연산 3. 오른쪽 90도 회전
	// 회전하면 N과 M이 바뀐다는 점에 애를 좀 먹었다.
	// 임시 배열을 하나 만들어서 값을 옮기고
	// N과 M을 스왑해주었다.
	private static void op3() {
		int[][] result = new int[M][N];
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				result[i][j] = map[N-1-j][i];
			}
		}
		
		int temp = N;
		N = M;
		M = temp;
		map = result;
	}

	// 연산 4. 왼쪽 90도 회전
	// 연산 3이랑 방법은 같고 인덱스만 좀 바꾼 것
	private static void op4() {
		int[][] result = new int[M][N];
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				result[i][j] = map[j][M-1-i];
			}
		}
		
		int temp = N;
		N = M;
		M = temp;
		map = result;
	}

	// 연산 5. 사분면 오른쪽 90도 회전
	// temp 배열에 사분면 1을 저장하고
	// 다른 사분면을 하나씩 땡겨온 다음에
	// 원래 1이 이동할 자리에 temp를 옮겨준다.
	private static void op5() {
		int[][] temp = new int[N/2][M/2];
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < M/2; j++) {
				// temp로 옮기면서
				temp[i][j] = map[i][j];
				// 4사분면을 1사분면으로 땡겨옴
				map[i][j] = map[(N/2)+i][j];
			}
		}
		
		// 3사분면 -> 4사분면
		for(int i = N/2; i < N; i++) {
			for(int j = 0; j < M/2; j++) {
				map[i][j] = map[i][(M/2)+j];
			}
		}
		
		// 2사분면 -> 3사분면
		for(int i = N/2; i < N; i++) {
			for(int j = M/2; j < M; j++) {
				map[i][j] = map[i-(N/2)][j];
			}
		}
		
		// 1사분면 -> 2사분면
		for(int i = 0; i < N/2; i++) {
			for(int j = M/2; j < M; j++) {
				map[i][j] = temp[i][j-(M/2)];
			}
		}
	}

	// 연산 6. 사분면 왼쪽 90도 회전
	// 방식은 5랑 같고 이동 방향만 다르다.
	private static void op6() {
		int[][] temp = new int[N/2][M/2];
		// 2사분면 -> 1사분면
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < M/2; j++) {
				temp[i][j] = map[i][j];
				map[i][j] = map[i][j+(M/2)];
			}
		}
		
		// 3사분면 -> 2사분면
		for(int i = 0; i < N/2; i++) {
			for(int j = M/2; j < M; j++) {
				map[i][j] = map[i+(N/2)][j];
			}
		}	
		
		// 4사분면 -> 3사분면
		for(int i = N/2; i < N; i++) {
			for(int j = M/2; j < M; j++) {
				map[i][j] = map[i][j-(M/2)];
			}
		}
		
		// 1사분면 -> 4사분면
		for(int i = N/2; i < N; i++) {
			for(int j = 0; j < M/2; j++) {
				map[i][j] = temp[i-(N/2)][j];
			}
		}
	}
}
