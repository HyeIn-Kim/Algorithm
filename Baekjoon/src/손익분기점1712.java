import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 손익분기점1712 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		// 판매금액이 부가비용보다 작으면 이윤을 추출할 수 없으므로
		// -1 출력하고 종료
		if(B >= C) {
			System.out.println(-1);
			return;
		}
		
		// 아니라면 식에 맞는 결과를 출력
		System.out.println((A / (C-B)) + 1);
	}

}
