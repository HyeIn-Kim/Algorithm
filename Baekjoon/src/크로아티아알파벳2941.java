import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 크로아티아알파벳2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 비교할 크로아티아 알파벳
		String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		String input = br.readLine();	// 입력값
		
		int length = input.length();	// 전체 문자열 길이 저장
		int idx = 0;					// 현재 비교 시작하는 위치
		int cnt = 0;					// 알파벳 개수
		String substr = "";				// 여기에 문자열을 잘라서 크로아티아 알파벳이랑 비교할거임
		// 문자열 범위를 벗어나지 않는 선에서
		while(idx < length) {
			// 범위 안이라면 먼저 2글자씩 자를 것이므로
			// 현재위치+2가 범위에서 벗어나지 않는지 체크한다.
			// 3개짜리는 "dz="밖에 없으므로 2개로 잘라서 "dz"가 나오면 3글자로 다시 잘랐음
			if(idx+2 <= length) substr = input.substring(idx, idx+2);
			if(substr.equals("dz") && idx+3 <= length) substr = input.substring(idx, idx+3);
			
			int d = 1;	// 인덱스 증가량
			for(int i = 0; i < croatia.length; i++) {
				// 만약 크로아티아 알파벳이라면 idx는 알파벳 글자수만큼 증가함.
				// 알파벳을 찾지 못했다면 한글자 알파벳, 증가량은 그대로 1
				if(croatia[i].equals(substr)) {
					d = substr.length();
					break;
				}
			}
			// 알파벳을 찾았으니 cnt를 더해주고 idx에 증가량 d를 더해줌
			cnt++;
			idx += d;
		}
		
		System.out.println(cnt);
	}

}
