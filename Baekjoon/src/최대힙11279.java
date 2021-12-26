import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 최대 힙 직접 구현하기. 간단할 줄 알았는데 실수해서 생각보다 오래 걸렸다.
// 최대 힙 ==> 부모 노드의 키 값이 자식 노드의 키 값보다 크거나 같은 완전 이진 트리
// 완전 이진 트리이므로 배열로 구현하였다.
public class 최대힙11279 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] maxHeap = new int[N+1];
		// 계산의 편의를 위해 1부터 시작
		int idx = 1;
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			// 힙 삭제
			if(input == 0) {
				sb.append(maxHeap[1] + "\n");
				if(idx != 1) {
					// 힙의 맨 마지막 요소를 루트 노드로 옮긴다.
					maxHeap[1] = maxHeap[--idx];
					// 맨 마지막 노드는 삭제
					maxHeap[idx] = 0;
					
					int j = 1;
					while(j * 2 <= idx) {
						// 모든 자식 노드들보다 크다면 탐색 종료
						if(maxHeap[j] >= maxHeap[j * 2] && maxHeap[j] >= maxHeap[j * 2 + 1]) break;
						
						// 여기서 실수를 했었는데,
						// 처음에는 if ~ else로 왼쪽 자식, 오른쪽 자식을 차례차례 비교했었다.
						// 그런데 최대 힙 특성 상 왼쪽, 오른쪽 자식 중 더 값이 큰 자식과 값을 바꾸어야 했다.
						// 자식들 중에서 어떤 자식이 더 큰지 찾고
						int next = j * 2;
						if(maxHeap[j * 2] < maxHeap[j * 2 + 1]) next = j * 2 + 1;
						
						// 해당 자식과 부모를 바꿔준다.
						if(maxHeap[j] < maxHeap[next]) {
							int temp = maxHeap[j];
							maxHeap[j] = maxHeap[next];
							maxHeap[next] = temp;
							
							j = next;
						}
					}
				}
			}
			
			// 힙 삽입
			else {
				// 맨 끝에 값을 삽입하고
				maxHeap[idx] = input;
				// 루트까지 올라오면서 자리를 바꿔준다!
				for(int j = idx; (j/2) >= 1; j /= 2) {
					if(maxHeap[j] > maxHeap[j/2]) {
						int temp = maxHeap[j];
						maxHeap[j] = maxHeap[j/2];
						maxHeap[j/2] = temp;
					}
					else break;
				}
				idx++;
			}
		}
		
		System.out.println(sb.toString());
	}

}
