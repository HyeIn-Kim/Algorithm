import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 방배정13300 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());	// 총 학생 수
		int K = Integer.parseInt(st.nextToken());	// 1방 최대인원
		int[][] student = new int[2][7];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());	// 성별
			int Y = Integer.parseInt(st.nextToken());	// 학년
			student[S][Y]++;
		}
		
		int cnt = 0;
		for(int i = 0; i < 2; i++) {
			for(int j = 1; j <= 6; j++) {
				// 학생들을 K명만큼 방 배정함
				int room = student[i][j] / K;
				// 그리고 남는 학생이 있다면 방 하나 추가
				if(student[i][j] % K != 0) room++;
				cnt += room;
			}
		}
		System.out.println(cnt);
	}

}
