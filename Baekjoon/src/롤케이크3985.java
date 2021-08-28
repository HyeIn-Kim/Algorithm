import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 롤케이크3985 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());	// 롤케이크 길이
		int N = Integer.parseInt(br.readLine());	// 사람 수
		
		int[] rollcake = new int[L+1];	// 롤케이크 저장 배열(0은 더미)
		int expectedMax = 0;		// 가장 많이 먹을 롤케이크 조각 수
		int expectedPerson = 0;		// 롤케이크를 가장 많이 먹기로 예상되는 사람의 번호
		int max = 0;				// 실제로 가장 많이 먹을 수 있는 조각 수
		int maxPerson = 0;			// 실제로 가장 많이 먹는 사람
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			// 롤케이크의 길이가 가장 큰 사람을 구해줌
			if(end - start > expectedMax) {
				expectedMax = end - start;
				expectedPerson = i;
			}
			
			// 실제로 롤케이크를 가장 많이 먹는 사람을 찾음
			int cnt = 0;
			for(int j = start; j <= end; j++) {
				// 롤케이크가 0이 아니라면, 이미 누가 찜해놓은 자리
				if(rollcake[j] == 0) {
					cnt++;
					rollcake[j] = i;
				}
			}
			
			if(cnt > max) {
				max = cnt;
				maxPerson = i;
			}
		}
		
		System.out.println(expectedPerson);
		System.out.println(maxPerson);
	}

}
