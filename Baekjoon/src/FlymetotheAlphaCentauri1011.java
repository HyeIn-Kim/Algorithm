import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 복잡도를 보면 반복문, 재귀같은 걸 돌리면 무조건 터지니까
// 분명 공식이 있을텐데 도저히 모르겠어서 답 봤다..ㅜㅠㅜ
// 1 + 2 + ... n-1 + n + n-1 + ...  + 2 + 1 = n^2 라는 사실을 처음 알았다.
// 그리고 이동 횟수는 2n - 1이다.
// 참고로 (n+1)^2는 ↑ 이동횟수+2다.
// 이동횟수는 2n - 1에서 n만큼 갈때마다 1씩 늘어난다.
public class FlymetotheAlphaCentauri1011 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dist = y - x;
			
			int max = (int) Math.sqrt(dist);
			if(max * max == dist) sb.append(((2 * max) - 1) + "\n");
			else if(dist <= (max * max) + max) sb.append((2 * max) + "\n");
			else sb.append(((2 * max) + 1) + "\n");
		}
		System.out.println(sb);
	}

}
