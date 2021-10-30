import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분수찾기1193 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int sum = 0;			// 1+2+3+...+idx까지의 합
		int idx = 1;			// idx
		while(true) {
			// 등차수열을 구하다가
			sum += idx;
			// N보다 크거나 같아지면 종료
			if(sum >= N) break;
			idx++;
		}
		
		//    1
		//   2  3
		//  4  5  6 에서
		// start는 4, end는 6이 됨
		int start = sum - (idx - 1);
		int end = sum;
		
		// 지그재그이므로 짝수일때는 1/N, 홀수일때는 N/1부터 시작함.
		// 따라서 홀짝에 맞게 식을 써서 분수를 구했다.
		int before = (idx % 2 == 0) ? 1 + (N - start) : 1 + (end - N);
		int after = (idx % 2 == 0) ? 1 + (end - N) : 1 + (N - start);
		System.out.println(before + "/" + after);
	}

}
