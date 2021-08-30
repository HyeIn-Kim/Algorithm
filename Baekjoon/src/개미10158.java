import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 개미10158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int startC = Integer.parseInt(st.nextToken());
		int startR = Integer.parseInt(st.nextToken());
		
		long t = Long.parseLong(br.readLine());
		// 개미는 반사되므로 c * 2시간 후에는 startC(원래 C위치)로 돌아오고
		// r * 2시간 후에는 startR(원래 R위치)로 돌아온다.
		// 나머지 연산(%)으로 왕복한 시간을 제거해준다.
		int modC = (int)t % (c * 2);
		int modR = (int)t % (r * 2);
		
		// 도착지점의 R, C 좌표
		int resultC = 0;
		int resultR = 0;
		
		// 가로: -> / <- / -> 이동해서 제자리로 돌아옴
		// -> 방향 검사
		if(c - startC >= modC) resultC = startC + modC;
		else {
			modC -= c - startC;
			// <- 방향 검사
			if(modC <= c) resultC = c - modC;
			// -> 방향 검사
			else {
				modC -= c;
				resultC = modC;
			}
		}
		
		// 세로: ↓ / ↑ / ↓ 이동해서 제자리로 돌아옴
		// ↓ 방향 검사
		if(r - startR >= modR) resultR = startR + modR;
		else {
			modR -= r - startR;
			// ↑ 방향 검사
			if(modR <= r) resultR = r - modR;
			// ↓ 방향 검사
			else {
				modR -= r;
				resultR = modR;
			}
		}
		System.out.println(resultC + " " + resultR);
	}

}
