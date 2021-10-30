import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 킹1063 {

	// 방향은 Map에, 증가치는 dr, dc에 저장하였음
	static HashMap<String, Integer> map;
	static int[] dr = {0, 0, 1, -1, -1, -1, 1, 1};
	static int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new HashMap<>();
		map.put("R", 0);
		map.put("L", 1);
		map.put("B", 2);
		map.put("T", 3);
		map.put("RT", 4);
		map.put("LT", 5);
		map.put("RB", 6);
		map.put("LB", 7);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String king = st.nextToken();
		String stone = st.nextToken();
		int N = Integer.parseInt(st.nextToken());
		
		// 입력받은 좌표를 0~N-1 사이로 변환해준다.
		int kr = '8' - king.charAt(1);
		int kc = king.charAt(0) - 'A';
		
		int sr = '8' - stone.charAt(1);
		int sc = stone.charAt(0) - 'A';
		
		// N회 이동
		for(int i = 0; i < N; i++) {
			// 입력받은 방향을 확인하고
			String dir = br.readLine();
			int d = map.get(dir);
			// 다음 킹의 좌표를 구한다.
			int nr = kr + dr[d];
			int nc = kc + dc[d];
			
			// 범위를 벗어나면 pass
			if(nr < 0 || nc < 0 || nr >= 8 || nc >= 8) continue;
			
			// 킹의 다음 좌표가 돌이라면
			if(nr == sr && nc == sc) {
				// 돌을 1칸 움직이는데
				int nsr = sr + dr[d];
				int nsc = sc + dc[d];
				// 범위를 벗어나면 pass
				if(nsr < 0 || nsc < 0 || nsr >= 8 || nsc >= 8) continue;
				
				// 돌 이동
				sr = nsr;
				sc = nsc;
			}
			
			// 킹 이동
			kr = nr;
			kc = nc;
		}
		
		// 좌표를 다시 입력받은대로 변환해준다!
		System.out.println((char)('A' + kc) + "" + (char)('8' - kr));
		System.out.println((char)('A' + sc) + "" + (char)('8' - sr));
	}

}
