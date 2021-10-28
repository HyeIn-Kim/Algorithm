import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 윷놀이2490 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 3번의 윷놀이 중에서
		for(int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = 0;
			// 윷 상태를 입력받고
			for(int j = 0; j < 4; j++) {
				int input = Integer.parseInt(st.nextToken());
				// 등일때만 카운트 셈
				if(input == 1) cnt++;
			}
			
			// 윷에 따라서 결과를 출력해주면 끝!
			char result = '0';
			switch(cnt) {
				case 3: result = 'A'; break;
				case 2: result = 'B'; break;
				case 1: result = 'C'; break;
				case 0: result = 'D'; break;
				case 4: result = 'E'; break;
			}
			sb.append(result + "\n");
		}
		System.out.println(sb);
	}

}
