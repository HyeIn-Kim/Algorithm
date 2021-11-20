import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// LSI 연습문제!
public class 가장긴감소하는부분수열11722 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] numbers = new int[N];
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		int[] LSI = new int[N];
		for(int i = 0; i < N; i++) {
			LSI[i] = 1;
			for(int j = 0; j < i; j++) {
				// 증가하는 수열이 아니라 감소하는 수열이므로 부등호 방향만 바꿔주면 된다.
				if(numbers[j] > numbers[i] && LSI[j] + 1 > LSI[i]) {
					LSI[i] = LSI[j] + 1;
				}
			}
			max = Math.max(max, LSI[i]);
		}
		System.out.println(max);
	}

}