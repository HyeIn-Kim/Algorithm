import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N = 7
// 3 7 5 2 6 1 4 에서, 자리는 최소 4번 바꿔야 한다.
// 바꾸지 않는 자리는 3, 5, 6 -> 가장 큰 증가하는 부분수열이다!
// 즉, N에서 최대 LSI를 빼면 최소로 자리를 바꾸는 횟수가 나온다!
public class 줄세우기2631 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		
		// 1. LSI를 구한다!
		int max = 0;
		int[] LSI = new int[N];
		for(int i = 0; i < N; i++) {
			LSI[i] = 1;
			for(int j = 0; j < i; j++) {
				if(input[j] < input[i] && LSI[j] + 1 > LSI[i]) {
					LSI[i] = LSI[j] + 1;
				}
			}
			max = Math.max(max, LSI[i]);
		}
		
		// 2. N에서 최대 LSI를 빼서 최소로 자리를 바꾸는 횟수를 출력한다!
		System.out.println(N - max);
	}

}
