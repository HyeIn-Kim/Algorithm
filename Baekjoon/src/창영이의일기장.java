import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 창영이의일기장 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++) {
			// 현재 문자를 받아옴
			char curr = str.charAt(i);
			
			// 현재 문자가 p라면, 앞뒤 문자가 같은 모음인지 검사할 것임.
			// 따라서 i 범위가 length를 벗어나지 않는지 검사함.
			if(i > 0 && i < str.length()-1 && curr == 'p') {
				// 이전 문자와 다음 문자를 받아옴.
				char prev = str.charAt(i-1);
				char next = str.charAt(i+1);
				
				// pipipepe -> pipe의 예시처럼,
				// p 앞뒤로 오는 모음은 서로 같아야 함.
				if((prev == 'a' && next == 'a') || (prev == 'e' && next == 'e')
						|| (prev == 'i' && next == 'i') || (prev == 'o' && next == 'o')
						|| (prev == 'u' && next == 'u')) {
					// p 뒤의 모음은 원래 문자열이 아니라 암호로 붙은 것이므로
					// 넘기기 위해 i++ 하였음.
					i++;
					continue;
				}
			}
			sb.append(curr);
		}
		
		System.out.println(sb);
	}

}
