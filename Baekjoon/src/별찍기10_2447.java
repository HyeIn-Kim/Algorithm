import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 잘게잘게 쪼개서 하면 된다는건 알았는데~~
// 출력을 어떻게 하지? 싶어서 한참을 고민했다.
// 2차원 배열을 만드는 건 생각도 못했어.. 그냥 깡으로 출력하는줄...
// boolean형 배열을 만들어서, true이면 별 false이면 공백으로 출력했다.
public class 별찍기10_2447 {

	static boolean[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new boolean[N][N];
		
		// 재귀 시작!
		star(0, 0, N);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				sb.append((arr[i][j]) ? "*" : " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void star(int x, int y, int n) {
		// 더 나눠지지 않으면 배열에 값을 갱신해준다.
		if(n == 3) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					// 비어있는 가운데 칸은 pass
					if(i == 1 && j == 1) continue;
					arr[y + i][x + j] = true;
				}
			}
			return;
		}
		
		// n이 3보다 크다면 n/3으로 재귀한다.
		// 갱신할 x, y 위치를 기억해야 하므로 인자에 x, y를 추가해주었다.
		int size = n/3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				// 비어있는 가운데 칸은 pass
				if(i == 1 && j == 1) continue;
				star(x + j * size, y + i * size, size);
			}
		}
	}

}
