import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 단어뒤집기2_17413ver2 {

	// 기존 코드의 Queue와 ArrayList는 필요없는 것 같아서 제거한 버전
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> word = new Stack<>();
		
		for(int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if(c == '<') {
				while(!word.isEmpty()) sb.append(word.pop());
				sb.append(c);
				while(c != '>') {
					c = S.charAt(++i);
					sb.append(c);
				}
			}
			else if(c == ' ') {
				while(!word.isEmpty()) sb.append(word.pop());
				sb.append(c);
			}
			else word.push(c);
		}
		
		while(!word.isEmpty()) sb.append(word.pop());
		System.out.println(sb);
	}

}
