import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로또6603 {

	static int N;					// 전체 입력 길이
	static int[] input;				// 입력값
	static boolean[] isSelected;	// 선택여부 배열
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
			isSelected = new boolean[N];
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
		// 숫자를 6개 뽑았다면
		if(cnt == 6) {
			for(int i = 0; i < N; i++) {
				// 선택된 숫자들을 출력
				if(isSelected[i]) sb.append(input[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		// 중복 제거를 위해 0부터 안돌고 start부터 시작
		for(int i = start; i < N; i++) {
			// 숫자를 선택하려고 isSelected 배열을 두었는데
			// 굳이 이렇게 하지 않아도 됐을 듯함...
			// 선택되었다면 pass
			if(isSelected[i]) continue;
			
			// 선택되지 않은 숫자를 고르고
			isSelected[i] = true;
			// 나머지 자릿수 채우기
			permutation(i, cnt + 1);
			// 돌아왔으면 선택 해제하고 다음 숫자를 확인!
			isSelected[i] = false;
		}
	}

}
