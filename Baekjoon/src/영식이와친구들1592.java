import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 영식이와친구들1592 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] cnt = new int[N];		// 각 사람이 공을 몇 번 받았는지 저장할 배열
		int result = 0;				// 공을 던진 횟수
		int ball = 0;				// 현재 공 위치
		while(true) {
			cnt[ball]++;
			if(cnt[ball] == M) break;	// 한사람이 공을 M번 던졌다면 종료
			
			// 종료할 때는 공을 던지지 않고
			// 공을 받은 채로 끝나므로 break문 다음에 증가시켰음
			result++;
			
			// 홀수일 땐 시계방향(+)으로 던지고
			// 짝수일 땐 반시계방향(-)으로 던졌다.
			// 시계방향이므로 N + 1 = 1이고 1 - 1 = N이라는 점에 유의 (순환함)
			if(cnt[ball] % 2 == 1)
				ball = (ball + L >= N) ? (ball + L) - N : ball + L;
			else
				ball = (ball - L < 0) ? N + (ball - L) : ball - L;
		}
		
		System.out.println(result);
	}

}
