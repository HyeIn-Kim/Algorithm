import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 나에게 너무 어려운 색종이 붙이기..
// 항상 다음 색종이를 찾을 때 4방탐색을 해 버린다... 또 답봤다.. 접근조차 틀림..
public class 색종이붙이기17136 {

	static int[][] map;
	static int[] paper = {0, 5, 5, 5, 5, 5};
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		for(int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = Integer.MAX_VALUE;
		DFS(0, 0, 0);
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}

	private static void DFS(int r, int c, int cnt) {
		// 최솟값을 찾는 것이므로 cnt가 최솟값을 넘어가면 잘라주자!
		if(cnt >= result) return;
		
		int sr = -1;
		int sc = -1;
		
		// 색종이를 붙이기 시작할 곳의 좌표를 찾는다.
		// 시간 줄이려고 r, c(이전 색종이 붙였던 곳 좌표)부터 돌게 했는데 그럴 필요는 굳이 없는듯 하다.
		outer:
		for(int i = r; i < 10; i++) {
			for(int j = (i == r) ? c : 0; j < 10; j++) {
				if(map[i][j] == 1) {
					sr = i;
					sc = j;
					break outer;
				}
			}
		}
		
		// 더이상 붙일 곳이 없으면
		// 모든 칸을 다 시도해본 것이므로 최솟값을 갱신해준다.
		if(sr == -1 && sc == -1) {
			result = Math.min(result, cnt);
			return;
		}
		
		// 현재 칸에서 붙일 수 있는 가장 큰 색종이 찾기!
		int size = 0;
		for(int p = 5; p >= 1; p--) {
			if(!isAvailable(sr, sc, p)) continue;
			size = p;
			break;
		}
		
		// size와 같거나 작은 색종이들을 하나씩 붙여보고,
		// 재귀 돌아와서는 원래대로 되돌려줘야 제대로 탐색할 수 있다!
		for(int p = size; p >= 1; p--) {
			if(paper[p] == 0) continue;
			
			onPaper(sr, sc, p);
			paper[p]--;
			
			DFS(sr, sc, cnt + 1);
			
			offPaper(sr, sc, p);
			paper[p]++;	
		}
	}

	private static boolean isAvailable(int r, int c, int p) {
		// 범위를 벗어나거나
		if(r + p - 1 >= 10 || c + p - 1 >= 10) return false;
		
		for(int i = r; i < r + p; i++) {
			for(int j = c; j < c + p; j++) {
				// 색종이를 붙일 수 없다면 false
				if(map[i][j] == 0) return false;
			}
		}
		return true;
	}

	private static void onPaper(int r, int c, int p) {
		for(int i = r; i < r + p; i++) {
			for(int j = c; j < c + p; j++) {
				map[i][j] = 0;
			}
		}		
	}
	
	private static void offPaper(int r, int c, int p) {
		for(int i = r; i < r + p; i++) {
			for(int j = c; j < c + p; j++) {
				map[i][j] = 1;
			}
		}			
	}
}
