import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 양념반후라이드반16917 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int price = A * X + B * Y;
		int max = Math.max(X, Y);
		for(int i = 1; i <= max; i++) {
			int price2 = (i * (C * 2)) + (((X-i < 0) ? 0 : X-i) * A) + (((Y-i < 0) ? 0 : Y-i) * B);
			if(price2 < price) price = price2;
		}
		System.out.println(price);
	}

}
