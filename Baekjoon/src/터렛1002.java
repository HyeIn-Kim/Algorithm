import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구현보다 수학이 더 어려운 문제(2)
public class 터렛1002 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			// 두 원 사이의 거리 d를 구한다.
			double d = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
			
			// 무수히 많은 점에서 만나는 경우: 같은 원
			if(d == 0 && r1 == r2) {
				sb.append(-1 + "\n");
			}
			
			// 만나지 않는 경우: 외접/내접하지 않는 경우
			else if(d > (r1 + r2) || d < Math.abs(r1 - r2)) {
				sb.append(0 + "\n");
			}
			
			// 한 점에서 만나는 경우: 외접/내접하는 경우
			else if(d == (r1 + r2) || d == Math.abs(r1 - r2)) {
				sb.append(1 + "\n");
			}
			
			// 두 점에서 만날 경우
			else if(d < r1 + r2) {
				sb.append(2 + "\n");
			}
		}
		
		System.out.println(sb);
	}

}
