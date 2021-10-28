import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구현능력을 기르기 위해 클래스 안쓰고 직접 해봤는데
// 올림하다가.. (A+B+올림)%10 을 해야하는데 (A+B)%10을 해서 한참 헤맸다 ㅠㅠ
public class 큰수A더하기B10757 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// A, B를 입력받는다.
		String inputA = st.nextToken();
		String inputB = st.nextToken();
		
		// A, B중에 더 큰 자리를 구하고
		int size = Math.max(inputA.length(), inputB.length());
		
		// 맨 끝자리에서 올림이 일어날 수 있으므로 길이 + 1만큼 잡아주고
		int[] A = new int[size + 1];
		int[] B = new int[size + 1];
		
		// 끝자리부터 계산하기 위해 배열을 뒤집어서 넣어준다.
		int idx = 0;
		for(int i = inputA.length() - 1; i >= 0; i--) {
			A[idx++] = inputA.charAt(i) - '0';
		}
		
		idx = 0;
		for(int i = inputB.length() - 1; i >= 0; i--) {
			B[idx++] = inputB.charAt(i) - '0';
		}
		
		// A, B를 뒤집었으면 답을 구해준다.
		int[] answer = new int[size + 1];
		for(int i = 0; i < size; i++) {
			// 올림 + A + B를 더해서
			int value = answer[i] + A[i] + B[i];
			// 10으로 나눈 나머지를 저장하고
			answer[i] = value % 10;
			// 다음자리에 올림수를 저장한다.
			answer[i+1] = (value / 10);
		}
		
		StringBuilder sb = new StringBuilder();
		// 맨 앞자리가 1일때만 넣어주고
		if(answer[size] != 0) sb.append(answer[size]);
		// 이번엔 뒤에서부터 한자리씩 붙여주면 순서가 다시 원래대로 돌아온다.
		for(int i = size - 1; i >= 0; i--) {
			sb.append(answer[i]);
		}
		
		// 출력
		System.out.println(sb);
	}

}
