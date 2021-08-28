import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 단어뒤집기2_17413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		Stack<Character> word = new Stack<>();
		Queue<Character> tag = new LinkedList<>();
		ArrayList<Character> result = new ArrayList<>();
		
		// 종류별로 if 조건을 주었는데
		// 차라리 태그인지 아닌지 구분하는 boolean 변수가 더 편했을지도 모르겠다.
		for(int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if(c == '<') {
				tag.offer(c);
				while(!word.isEmpty()) result.add(word.pop());
			}
			else if(c == '>') {
				tag.offer(c);
				while(!tag.isEmpty()) result.add(tag.poll());
			}
			else if(c == ' ' && tag.isEmpty()) {
				while(!word.isEmpty()) result.add(word.pop());
				result.add(c);
			}
			else if(tag.isEmpty()) word.push(c);
			else tag.offer(c);
		}
		
		while(!word.isEmpty()) result.add(word.pop());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < S.length(); i++) {
			sb.append(result.get(i));
		}
		System.out.println(sb);
	}

}
