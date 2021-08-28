import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 딱지놀이14696 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int R = Integer.parseInt(br.readLine());
		
		int[] cntA = new int[5];
		int[] cntB = new int[5];
		for(int i = 0; i < R; i++) {
			// cnt 배열 초기화
			Arrays.fill(cntA, 0);
			Arrays.fill(cntB, 0);
			// A 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			for(int j = 0; j < N; j++) {
				cntA[Integer.parseInt(st.nextToken())]++;				
			}

			// B 입력
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for(int j = 0; j < M; j++) {
				cntB[Integer.parseInt(st.nextToken())]++;				
			}
			
			// 승자 판단
			// 별(4)부터 개수를 비교해서 승자를 정한다.
			char winner = 'D';
			for(int j = 4; j >= 1; j--) {
				if(cntA[j] == cntB[j]) continue;
				else if(cntA[j] > cntB[j]) winner = 'A';
				else if(cntA[j] < cntB[j]) winner = 'B';
				break;
			}
			sb.append(Character.toString(winner) + '\n');
		}
		System.out.println(sb);
	}

}
