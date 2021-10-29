import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 개미3048 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		
		// 문자 A, B 입력: 한번에 찾으려고 한글자씩 HashSet에 넣었다.
		HashSet<Character> A = new HashSet<>();
		String inputA = br.readLine();
		for(int i = 0; i < n1; i++) {
			A.add(inputA.charAt(i));
		}
		
		HashSet<Character> B = new HashSet<>();
		String inputB = br.readLine();
		for(int i = 0; i < n2; i++) {
			B.add(inputB.charAt(i));
		}
		
		// 문자열 합치기
		int L = n1 + n2;
		char[] result = new char[L];
		for(int i = 0; i < L; i++) {
			// A 문자열을 거꾸로 붙이고
			if(i < n1)
				result[i] = inputA.charAt(n1 - 1 - i);
			// B 문자열을 이어준다.
			else
				result[i] = inputB.charAt(i - n1);
		}

		
		// T 시간만큼
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			// 처음부터 돌면서
			for(int i = 1; i < L; i++) {
				// A와 B가 만나면 둘 자리를 바꿔주고
				// 바꾼거라 다른 문자랑 더 비교할 필요 없으므로 i를 1 더해줘서 넘겼다.
				if(A.contains(result[i-1]) && B.contains(result[i])) {
					char temp = result[i-1];
					result[i-1] = result[i];
					result[i] = temp;
					i++;
				}
			}
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < L; i++) {
			sb.append(result[i]);
		}
		System.out.println(sb);
	}

}
