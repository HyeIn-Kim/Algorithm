import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 큰 약수 X 가장 작은 약수 = 원래 수
public class 약수1037 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			int number = Integer.parseInt(st.nextToken());
			max = Math.max(max, number);
			min = Math.min(min, number);
		}
		
		System.out.println(max * min);
	}

}
