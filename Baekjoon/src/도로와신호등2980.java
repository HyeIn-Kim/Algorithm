import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 도로와신호등2980 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		// 입력: 신호등 개수와 빨간불, 초록불 시간을 입력받는다.
		int[] D = new int[N];
		int[] red = new int[N];
		int[] green = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			D[i] = Integer.parseInt(st.nextToken());
			red[i] = Integer.parseInt(st.nextToken());
			green[i] = Integer.parseInt(st.nextToken());
		}
		
		int dist = 0;				// 상근이가 이동한 거리
		int time = 0;				// 현재까지 걸린 시간
		// 모든 신호등에 대해서
		for(int i = 0; i < N; i++) {
			// 이전거리에서 신호등까지 오는 시간을 더해주고
			time += D[i] - dist;
			// 거리를 신호등 위치로 갱신해준다.
			dist = D[i];
			
			// 신호등의 한 사이클: 빨간불 + 초록불
			int cycle = red[i] + green[i];
			// 현재 위치는 시간을 cycle로 나눠준 나머지가 되고
			int curr = time % cycle;
			// 빨간불보다 작다면 빨간불이므로
			if(curr < red[i]) {
				// 초록불로 바뀔때까지 시간을 더해준다.
				time += red[i] - curr;
			}
		}
		
		// 마지막 신호등까지 돌았으면
		// 마지막 신호등부터 목적지까지 시간을 더해주고 출력
		time += L - D[N-1];
		System.out.println(time);
	}

}
