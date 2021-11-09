import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 하노이탑이동순서11729 {

	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		sb = new StringBuilder();
		
		// 하노이탑 이동 횟수: 2^n -1
		sb.append((int)Math.pow(2, N) - 1 + "\n");
		
		// 차례대로 N, start, temp, end
		hanoi(N, 1, 2, 3);
		
		System.out.println(sb);
	}

	// 원판이 N개인 하노이탑을 옮기려면
	// N-1개짜리 하노이탑을 남는 기둥에 옮겨놔야 한다.
	private static void hanoi(int n, int start, int temp, int end) {
		if(n == 0) return; 
		
		// end에는 N이 옮겨질 것이므로, N-1 전체를 temp로 옮겨줌
		hanoi(n-1, start, end, temp);
		
		// N을 옮겼다고 치고
		sb.append(start + " " + end + "\n");
		
		// temp에 있던 N-1짜리 하노이탑을 end로 옮겨주면 끝!
		hanoi(n-1, temp, start, end);
	}

}
