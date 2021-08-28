import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OX퀴즈8958 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			int total = 0;		// 총 점수
			int cnt = 0;		// O가 몇번 반복되는지
			for(int j = 0; j < str.length(); j++) {
				// O일때만 연속된 O의 개수만큼 점수를 더해줬음
				if(str.charAt(j) == 'O') {
					cnt++;
					total += cnt;
				}
				else cnt = 0;
			}
			sb.append(total + "\n");
		}
		System.out.println(sb);
	}

}
