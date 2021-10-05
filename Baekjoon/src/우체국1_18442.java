import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 우체국1_18442 {

	static int V, P;				// V: 마을 / P: 경찰서 / L: 둘레
	static long L;
	static long[] map;				// 입력값 저장
	static long[][] dist;			// 마을 간의 거리를 저장하는 배열
	static int[] selected;			// 조합 선택용 배열
	static long answer;				// 결과값
	static PriorityQueue<Long> pq;		// 좌표 오름차순 정렬용 PQ
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 1. 입력: 입력 형식대로 입력받는다.
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		L = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		map = new long[V];
		for(int i = 0; i < V; i++) {
			map[i] = Long.parseLong(st.nextToken());
		}
		
		// 2. 각 마을마다 모든 마을까지의 거리를 미리 구해둔다.
		dist = new long[V][V];
		for(int i = 0; i < V; i++) {
			for(int j = 0; j < V; j++) {
				// |A - B|와 L - |A - B| 사이에서 작은 값을 거리로 정한다. 
				dist[i][j] = Math.min(Math.abs(map[i] - map[j]), L - Math.abs(map[i] - map[j]));
			}
		}
		
		// 3. 조합 선택: V개의 마을에 P개의 경찰서를 세워야 하므로 vCp의 조합이 된다.
		selected = new int[P];
		answer = Long.MAX_VALUE;
		Combination(0, 0);
		
		// 4. 출력
		sb.append(answer + "\n");
		while(!pq.isEmpty()) {
			sb.append(pq.poll() + " ");
		}
		System.out.println(sb);

	}

	private static void Combination(int cnt, int start) {
		// P개의 경찰서를 뽑았다면
		if(cnt == P) {
			long sum = 0;
			// 각 마을에 대하여
			for(int i = 0; i < V; i++) {
				long min = Long.MAX_VALUE;
				// 경찰서와의 최소 거리를 구한다.
				for(int j = 0; j < P; j++) {
					// 가장 가까운 경찰서 거리를 min에 저장
					min = Math.min(min, dist[i][selected[j]]);
				}
				
				// sum에 min을 더해줌으로써 모든 마을의 경찰서까지의 최소거리를 구한다.
				sum += min;
			}
			
			// 만약 현재 구한 최소거리가 기존 답보다 작을 경우
			if(sum < answer) {
				// 정답을 sum으로 교체하고
				answer = sum;
				
				// pq에 경찰서 위치를 집어넣는다.
				pq = new PriorityQueue<>();
				for(int i = 0; i < P; i++) {
					pq.add(map[selected[i]]);					
				}
			}
			return;
		}
		
		// 조합 코드
		for(int i = start; i < V; i++) {
			selected[cnt] = i;
			Combination(cnt + 1, i + 1);
		}
	}

}
