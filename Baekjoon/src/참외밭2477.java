import java.util.Scanner;

public class 참외밭2477 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] dist = new int[6];	// 거리를 저장할 배열
		int melon = sc.nextInt();	// 참외 개수
		
		// 입력 받는 부분
		for(int i = 0; i < 6; i++) {
			int dir = sc.nextInt();
			dist[i] = sc.nextInt();
		}
		
		// 인접한 변들을 곱해서 더하다 보면,
		// 빈 부분의 넓이는 3 * 전체넓이 - (인접한 변끼리의 곱의 합) 이 된다.
		// 따라서 전체넓이 (인접한 변을 곱해서 가장 큰 수: max)와
		// 인접한 변끼리의 곱의 합을 구해준다.
		// index가 범위를 넘지 않도록 % 연산자를 사용했다.
		int sum = 0;
		int max = 0;
		for(int i = 0; i < 6; i++) {
			sum += dist[i] * dist[(i+1) % 6];
			max = Math.max(max, dist[i] * dist[(i+1) % 6]);
		}
		
		// 구한 넓이에 참외 개수를 곱해주면 답
		int area = max - ((max * 3) - sum);
		System.out.println(area * melon);
	}

}
