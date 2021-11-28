import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 인트 범위!!!!!!!!!!! 확인!!!!!!!!!
// 그리디 문제는 많이 푼다고 해서 다음 문제 패턴이 보이는 게 아니지만
// 규칙을 찾아보려고 문제를 들여다보고 고민하는 시간에서
// 얻어갈 수 있는 게 많은 듯하다! 화이팅!!
public class 주유소13305 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] dist = new long[N-1];
		long[] oil = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N-1; i++) {
			dist[i] = Long.parseLong(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			oil[i] = Long.parseLong(st.nextToken());
		}
		
		long min = Long.MAX_VALUE;
		long sum = 0;
		for(int i = 0; i < N-1; i++) {
			if(oil[i] < min) {
				min = oil[i];
			}
			sum += min * dist[i];
		}
		
		System.out.println(sum);
	}

}
