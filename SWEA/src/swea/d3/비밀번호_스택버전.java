package swea.d3;

import java.util.Scanner;
import java.util.Stack;

public class 비밀번호_스택버전 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int T = 1; T <= 10; T++) {	
			int N = sc.nextInt();
			String str = sc.next();
			
			Stack<Character> stack = new Stack<Character>();
			for(int i = 0; i < str.length(); i++) {
				char curr = str.charAt(i);
				// Stack이 비어있다면 문자를 추가하고
				if(stack.isEmpty()) stack.push(curr);
				// Stack의 top과 현재 문자가 같다면 pop
				else if(stack.peek() == curr) stack.pop();
				// 같지 않다면 Stack에 push
				else stack.push(curr);
			}
			
			sb.append("#" + T + " ");
			for(Character s : stack)
				sb.append(s);
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
