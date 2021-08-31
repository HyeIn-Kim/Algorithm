import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 조커1205 {

	// 잘 안 풀려서 답을 찾아봤는데 재귀함수로 되어 있어서
	// 재귀함수는 좀 비효율적인거 같아 2중 반복문으로 고쳐본 것
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] card = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int joker = 0;
		for(int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			// 입력 받으면서 조커의 총 개수를 센다.
			if(card[i] == 0) joker++;
		}
		
		// 계산하기 편하도록 오름차순 정렬하였음
		Arrays.sort(card);
		int max = Integer.MIN_VALUE;	// 정답
		// 조커를 제외한 숫자들을 살펴본다.
		for(int i = joker; i < N; i++) {
			int straight = 1;	// 나 자신, 스트레이트는 1부터 시작
			int leftJoker = joker;	// 남은 조커 수
			
			// 나(i)로부터 몇개의 스트레이트가 될 수 있는지 센다.
			for(int j = i; j < N-1; j++) {
				// 둘이 같다면 스트레이트가 아님, pass
				if(card[j] == card[j+1]) continue;
				// 다음 카드가 1 증가한 값이라면 스트레이트 하나 추가
				else if(card[j] + 1 == card[j+1]) {
					straight++;
				}
				// 다음 카드까지의 차이를 조커가 메꿀 수 있으면 메꾸고 스트레이트 증가, 조커 없앰
				else if(leftJoker != 0 && card[j+1] - card[j] - 1 <= leftJoker) {
					straight += card[j+1] - card[j];
					leftJoker -= card[j+1] - card[j] - 1;
				}
				// 조커로 더이상 메꿀 수 없다면 스트레이트를 더 만들 수 없음. 종료
				else {
					break;
				}
			}
			// 반복문 종료 후에 조커가 남아있을 수도 있으므로 스트레이트에 더해줌
			straight += leftJoker;
			// 가장 큰 스트레이트값 갱신
			if(straight > max) max = straight;
		}
		
		// 만약 0 0 0 0 0 처럼 모든 카드가 조커라면 조커의 수가 스트레이트가 되므로 바꿔준다.
		if(joker == N) max = joker; 
		System.out.println(max);
	}

}
