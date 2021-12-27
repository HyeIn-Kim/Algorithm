import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 최대 힙에서 부등호만 바꾸면 되겠지? 했는데... 꼬였다!
public class 최소힙1927 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] minHeap = new int[N+1];
		int size = 1;
		
		for(int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				sb.append(minHeap[1] + "\n");
				if(size == 1) continue;
				
				minHeap[1] = minHeap[--size];
				minHeap[size] = 0;
				int curr = 1;
				while(curr * 2 < size) {
					int next = curr * 2;
					// 최소 힙에서는 배열 초기값을 0으로 하면 작아져버리니까
					// 오른쪽 자식이 있는지를 반드시! 확인해줘야 했다.
					// 처음에는 Integer.MAX_VALUE로 배열을 초기화했었는데
					// 힙 크기를 넘어가는 값이 계산에 사용돼서 그런지 틀렸다. 
					// 오른쪽 노드가 있고, 오른쪽 노드가 왼쪽보다 더 작다면 오른쪽과 비교
					if(curr * 2 + 1 < size && minHeap[curr * 2] > minHeap[curr * 2 + 1]) {
						next = curr * 2 + 1;
					}
					
					// 비교할 자식 노드보다 작으면 스왑
					if(minHeap[curr] > minHeap[next]) {
						int temp = minHeap[curr];
						minHeap[curr] = minHeap[next];
						minHeap[next] = temp;
						curr = next;
					}
					// 아닐 경우에는 여기까지 탐색하고 마침
					else break;
				}
			}
			else {
				// 힙의 맨 마지막에 입력값을 넣고
				minHeap[size] = input;
				
				// 최소 힙이 되도록 자리를 바꿔준다.
				int next = size;
				while(next / 2 >= 1) {
					if(minHeap[next] < minHeap[next / 2]) {
						int temp = minHeap[next];
						minHeap[next] = minHeap[next / 2];
						minHeap[next / 2] = temp;
						next = next / 2;
					}
					else break;
				}
				
				size++;
			}
		}
		
		System.out.println(sb.toString());
	}

}
