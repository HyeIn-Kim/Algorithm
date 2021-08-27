import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 비밀이메일2999 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();	// 암호 메세지
		int N = input.length();			// 메세지 길이
		
		ArrayList<Integer> rc = new ArrayList<>();
		// 메세지 길이 N의 공약수를 구한다.
		for(int i = 1; i <= N; i++) {
			if(N % i == 0) rc.add(i);
		}
		
		// r과 c를 구해주었다.
		// 홀짝에 따라서 값이 변해서 좀 애를 먹었다..
		// 회문도 그렇고 난 참 이거에 약한 것 같다.
		int r = (rc.size() % 2 == 0) ? (rc.size() / 2 - 1) : (rc.size() / 2);
		int c = (rc.size() % 2 == 0) ? r + 1 : r;
		r = rc.get(r);
		c = rc.get(c);
		
		// 결과값 저장 배열
		// 문제에서 r행 c열이면 배열로는 c X r로 만들어야 한다.
		char[][] answer = new char[c][r];
		int idx = 0;
		for(int i = 0; i < c; i++) {
			for(int j = 0; j < r; j++) {
				answer[i][j] = input.charAt(idx++);
			}
		}
		
		// 이제 열/행을 바꿔서 해독한 암호문을 출력한다.
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				sb.append(answer[j][i]);
			}
		}
		System.out.println(sb);
	}

}
