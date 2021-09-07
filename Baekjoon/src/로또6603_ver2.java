import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 엉망진창 조합코드를 개선한 버전
public class 로또6603_ver2 {

	static int N;					// 전체 입력 길이
	static int[] input;				// 입력값
	static int[] numbers;			// 선택된 숫자 배열
	static StringBuilder sb;		// 출력용 StringBuilder
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			// 0이 들어오면 입력 종료
			if(N == 0) break;
			
			// 입력
			input = new int[N];
			numbers = new int[6];
			for(int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			permutation(0, 0);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	// 아무 생각 없이 순열인줄 알고 함수 이름을 순열로 했는데
	// 짜고 나서 보니 조합이었다. 내 코드도 조합이었다.
	private static void permutation(int start, int cnt) {
		// cnt가 6이면 6자리 수를 선택한 것. 그대로 출력한다.
		if(cnt == 6) {
			for(int i = 0; i < 6; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		// isSelected 배열을 쓰지 않는 버전. 이쪽이 더 깔끔하다.
		for(int i = start; i < N; i++) {
			// 숫자를 선택! numbers는 계속 덧씌워지므로
			// 따로 선택 해제할 필요가 없다.
			numbers[cnt] = input[i];
			permutation(i + 1, cnt + 1);
		}
	}

}
