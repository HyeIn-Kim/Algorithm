import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 순열인가...? 싶었는데 n이 100까지여서 다시 한번 생각해 봄.
public class 블랙잭2798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] card = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		// 각 반복문은 카드 1장과 같다. 3장뽑으니까 3중반복문
		// 카드는 1장이므로 i, j, k가 중복되지 않도록 했고
		// 세 카드의 합이 M보다 작은것들 중에 가장 큰 값을 찾았다.
		int maxSum = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(j == i) continue;
				for(int k = 0; k < N; k++) {
					if(k == i || k == j) continue;
					int sum = card[i] + card[j] + card[k];
					if(sum <= M && sum > maxSum) maxSum = sum;
				}
			}
		}
		
		System.out.println(maxSum);
	}

}
