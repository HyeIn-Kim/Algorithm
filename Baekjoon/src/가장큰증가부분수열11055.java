import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// O(n^2) 알고리즘으로 짜본 것
public class 가장큰증가부분수열11055 {

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
			LSI[i] = numbers[i];
			for(int j = 0; j < i; j++) {
				if(numbers[j] < numbers[i] && LSI[j] + numbers[i] > LSI[i]) {
					LSI[i] = LSI[j] + numbers[i];
				}
			}
			max = Math.max(max, LSI[i]);
		}
		System.out.println(max);
	}

}
