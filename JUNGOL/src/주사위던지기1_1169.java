import java.util.Scanner;

public class 주사위던지기1_1169 {

	static int N, M;
	static int[] input = {1, 2, 3, 4, 5, 6};
	static int[] selected;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		selected = new int[N];
		visited = new boolean[6];
		switch(M) {
		case 1: solve1(0); break;
		case 2: solve2(0, 0); break;
		case 3: solve3(0); break;
		}
	}

	// 중복순열
	private static void solve1(int cnt) {
		if(cnt == N) {
			for(int i = 0; i < N; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < 6; i++) {
			selected[cnt] = input[i];
			solve1(cnt + 1);
		}
	}

	// 조합
	private static void solve2(int cnt, int start) {
		if(cnt == N) {
			for(int i = 0; i < N; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i < 6; i++) {
			selected[cnt] = input[i];
			solve2(cnt + 1, i);
		}
	}
	
	// 순열
	private static void solve3(int cnt) {
		if(cnt == N) {
			for(int i = 0; i < N; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < 6; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			selected[cnt] = input[i];
			solve3(cnt + 1);
			visited[i] = false;
		}
	}

}
