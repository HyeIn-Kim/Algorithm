import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM11399 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] p = new int[N];
		int total = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		// 가장 적게 걸리는 사람이 맨앞에 오도록 소트하고
		Arrays.sort(p);
		
		// 총 걸리는 시간의 합을 구해준다.
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += p[i];
			total += sum;
		}
		System.out.println(total);
	}

}
