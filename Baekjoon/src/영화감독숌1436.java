import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 구현하지 않아도..
// String.valueOf(i).contains("666")으로도 가능했다..!
public class 영화감독숌1436 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 첫번째 숫자는 666이니까 그냥 끝내버리자~
		if(N == 1) {
			System.out.println(666);
			return;
		}
		
		// 2번째 숫자인 1666부터 계산!
		int cnt = 1;
		int num = 1666;
		// N번째 종말의 수를 찾을 때까지
		while(cnt < N) {
			int temp = num;
			boolean isSix = false;	// 6을 찾으면 true
			int max = 0;			// 숫자에 있는 최대 6의 개수
			int six = 0;			// 연속 6의 개수
			// 666이 연속으로 있는지 계산.
			// 한글자씩 떼서
			while(temp > 0) {
				// 6이라면
				if(temp % 10 == 6) {
					// 처음 찾은 6이면 표시하고
					if(!isSix) isSix = true;
					// 6의 개수를 더해줌
					six++;
				}
				// 6이 아니라면
				else {
					// 6의 최대 개수를 갱신
					max = Math.max(max, six);
					// 연속 6 / 6의 개수를 초기화해준다.
					isSix = false;
					six = 0;
				}
				
				// 자릿수 나눠주기
				temp /= 10;
			}
			
			// 6으로 끝나는 경우를 생각해서 최대 개수를 다시 한번 계산!
			max = Math.max(max, six);
			
			// 3개 이상 연속이면 종말의 숫자다!
			if(max >= 3) cnt++;
			
			// N개를 찾으면 출력하고 종료
			if(cnt == N) {
				System.out.println(num);
				break;
			}			
			
			// num 증가
			num++;
		}
	}

}
