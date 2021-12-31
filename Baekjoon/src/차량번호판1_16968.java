import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 차량번호판1_16968 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int numbers = 10;
		int alphabets = 26;
		// 숫자가 연속인지, 연속이 아닌지 판단할 변수
		// 연속하지 않으면 26 - 0, 10 - 0 그대로 하고
		// 연속하면 26 - 1, 10 - 1 이렇게 중복 1개씩을 빼줌
		int d = 0;
		
		// 첫번째값 세팅
		int cnt = (input[0] == 'c') ? alphabets : numbers;
		// 두번째 문자부터 끝까지
		for(int i = 1; i < input.length; i++) {
			// 연속/불연속 판단하고
			if(input[i-1] == input[i]) {
				if(d == 0) d = 1;
			}
			else {
				if(d == 1) d = 0;
			}
			
			// 상황에 맞게 d를 빼주면서 곱해줌
			cnt *= (input[i] == 'c') ? alphabets - d : numbers - d;
		}
		
		System.out.println(cnt);
	}

}
