import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 배수와약수5086 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			if(n1 == 0 && n2 == 0) break;
			
			// 두번째 수를 첫번째 수로 나눠서 나누어 떨어지면 약수
			if(n2 % n1 == 0) sb.append("factor\n");
			// 첫번째 수를 두번째 수로 나눠서 나누어 떨어지면 배수
			else if(n1 % n2 == 0) sb.append("multiple\n");
			// 둘 다 아니라면 X
			else sb.append("neither\n");
		}
		
		System.out.println(sb);
	}

}
