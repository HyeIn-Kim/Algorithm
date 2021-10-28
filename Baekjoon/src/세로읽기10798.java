import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 세로읽기10798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 5줄의 입력이 들어오므로 String 배열에 담자
		String[] str = new String[5];
		for(int i = 0; i < 5; i++) {
			str[i] = br.readLine();
		}
		
		StringBuilder sb = new StringBuilder();
		// 최대 15글자까지 담을 수 있으므로 15까지
		for(int c = 0; c < 15; c++) {
			// 5개의 문자열
			for(int r = 0; r < 5; r++) {
				// 현재 출력하는 곳이 문자열 길이보다 크면 pass
				if(c >= str[r].length()) continue;
				// 아니라면 문자열을 StringBuilder에 담는다.
				sb.append(str[r].charAt(c));
			}
		}
		
		// 출력
		System.out.println(sb);
	}

}
