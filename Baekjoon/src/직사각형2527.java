import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 직사각형2527 {

	// 이때 조급해서 그런지
	// 빨리빨리 문제를 풀고 싶은 마음에
	// 깊게 고민해보지 않은 상태로 도전했다가 크게 헤맸다.
	// 오히려 처음부터 차근차근 모든 경우를 따져봤다면
	// 좀 더 쉽게 풀 수 있었을까?
	static class Rectangle {
		int x, y;
		int p, q;

		public Rectangle(int x, int y, int p, int q) {
			super();
			this.x = x;
			this.y = y;
			this.p = p;
			this.q = q;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int r = 0; r < 4; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			Rectangle r1 = new Rectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Rectangle r2 = new Rectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			// 처음에는 안겹치는 상태(d)를 default로 두고 풀었는데
			// 너무 안 풀려서 풀이를 찾아보니 점, 선분, 안겹칠때를 먼저 찾고
			// 나머지를 겹침(a)으로 두라고 했다.
			char result = 'a';
			
			// 점(c)은 사각형 r1의 모든 꼭지점을 돌면서 겹치는지 확인
			if((r1.x == r2.p && r1.y == r2.q) || (r1.p == r2.x && r1.y == r2.q)
					|| (r1.x == r2.p && r1.q == r2.y) || (r1.p == r2.x && r1.q == r2.y)) result = 'c';
			// 선분(b)은 꼭지점 x,y중 하나는 맞고 하나는 다를 경우이다.
			else if((r1.p == r2.x && r1.q != r2.y) || (r1.x == r2.p && r1.q != r2.y)
					|| (r1.p != r2.x && r1.y == r2.q) && (r1.x != r2.p && r1.y == r2.q)) result = 'b';
			// 안 겹칠 때(d)는 둘의 범위가 겹치지 않을 때.
			else if(r1.p < r2.x || r2.p < r1.x || r1.q < r2.y || r2.q < r1.y) result = 'd';

			sb.append(result + "\n");
		}
		System.out.println(sb);

	}

}
