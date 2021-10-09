package swea.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 보물상자비밀번호 {

	// 10진수 - 16진수 매칭용 배열. index가 10진수이다!
	static char[] hexadecimal = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			// 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			// 문자열 삽입/삭제를 편하게 하기 위해 StringBuilder 형으로 받았음
			StringBuilder input = new StringBuilder(br.readLine());
			
			int R = N/4;								// 문자열은 N/4회만큼 회전한다.
			HashSet<Integer> set = new HashSet<>();		// 중복 거름용 Set
			for(int i = 0; i < R; i++) {
				// 첫번째 글자를 삭제한 후 맨 뒤에 삽입해줌
				char first = input.charAt(0);
				input.deleteCharAt(0);
				input.append(first);
				
				// 길이 R만큼 서브스트링으로 잘라서 숫자로 변환 후 Set에 추가!
				for(int j = 0; j < N; j += R) {
					set.add(toDecimal(input.substring(j, j + R)));			
				}
			}
			
			// Set에 들어있는 숫자들을 꺼내서 리스트에 집어넣고
			ArrayList<Integer> list = new ArrayList<>();
			for(Integer i : set) {
				list.add(i);
			}
			
			// 내림차순으로 정렬하였다.
			Collections.sort(list);
			Collections.reverse(list);
			
			int size = list.size();
			for(int i = 0; i < size; i++) {
				// 만약 K번째로 큰 수라면 답이다!
				if(i+1 == K) {
					sb.append("#" + testCase + " " + list.get(i) + "\n");
				}
			}
		}
		
		System.out.println(sb);
	}

	private static int toDecimal(String str) {
		int length = str.length();
		int result = 0;
		// 내가 생각하기 쉽도록 맨 뒤에서부터 했는데 앞에서부터 해도 상관 없을듯하다.
		// 어쨌든 맨 뒤 숫자부터
		for(int i = length - 1; i >= 0; i--) {
			// 10진수와 매칭시켜서
			for(int j = 1; j < 16; j++) {
				if(str.charAt(i) == hexadecimal[j]) {
					// 16 * (length-i-1)제곱 * 10진수를 결과값에 쭉쭉 더해준다!
					result += (Math.pow(16, length-i-1) * j);
				}
			}
		}
		
		return result;
	}

}
