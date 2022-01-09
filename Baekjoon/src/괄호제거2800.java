import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.TreeSet;

public class 괄호제거2800 {

	static int N, pairCnt;
	static boolean isFirst = true;
	static char[] input;
	static int[] pairs;					// 괄호 쌍
	static boolean[] selected;
	static StringBuilder sb;
	static TreeSet<String> set;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().toCharArray();
		N = input.length;
		pairs = new int[N];
		
		// 1. Stack을 사용하여 괄호 쌍을 찾기
		Stack<Integer> stack = new Stack<>();
		pairCnt = 1;
		for(int i = 0; i < N; i++) {
			if(input[i] == '(') {
				stack.push(i);
				pairs[i] = pairCnt++;
			}
			else if(input[i] == ')') {
				int prev = stack.pop();
				pairs[i] = pairs[prev];
			}
		}
		
		sb = new StringBuilder();
		set = new TreeSet<>();
		selected = new boolean[pairCnt];
		// 2. 완전탐색으로 괄호를 없애는 모든 경우 찾기
		permutation(0, 1);
		
		// 3. set의 모든 원소들을 꺼내서 출력
		// TreeSet을 이용하면 사전순으로 알아서 정렬해준다.
		for(String s : set) {
			sb.append(s + "\n");
		}
		
		System.out.println(sb);
	}

	private static void permutation(int cnt, int start) {
		if(cnt == pairCnt - 1) {
			// 첫번째 값은 입력값이랑 똑같으므로 pass
			if(isFirst) {
				isFirst = false;
				return;
			}
			
			// 괄호쌍을 만들어보고 set에 넣음
			StringBuilder temp = new StringBuilder();
			for(int i = 0; i < N; i++) {
				if(pairs[i] != 0 && !selected[pairs[i]]) continue;
				temp.append(input[i]);
			}
			
			set.add(temp.toString());
			return;
		}
		
		for(int i = start; i < pairCnt; i++) {
			if(selected[i]) continue;
			selected[i] = true;
			permutation(cnt + 1, i + 1);
			selected[i] = false;
			permutation(cnt + 1, i + 1);
		}
	}

}
