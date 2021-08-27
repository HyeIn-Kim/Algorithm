import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 컵홀더2810 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		
		int people = input.length();
		// 일반 좌석만 있다면, 한 줄에 컵홀더는 사람 수 + 1개
		int cupHolder = people + 1;
		int coupleSeat = 0;
		for(int i = 0; i < people; i++) {
			if(input.charAt(i) == 'L') coupleSeat++;
		}
		// 한 쌍의 커플석(LL)개수만큼 빼서 총 컵홀더 개수를 구한다.
		cupHolder -= (coupleSeat/2);
		
		// 컵홀더 개수가 사람 수보다 많으면 모든 사람들이 컵홀더를 쓸 수 있으므로
		// 컵홀더 개수 대신 사람 수를 출력했다.
		System.out.println((cupHolder > people) ? people : cupHolder);
	}

}
