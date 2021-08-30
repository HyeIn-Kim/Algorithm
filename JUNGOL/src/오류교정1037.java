import java.util.ArrayList;
import java.util.Scanner;

public class 오류교정1037 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] message = new int[N][N];
		// 입력
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				message[i][j] = sc.nextInt();
			}
		}
		
		// 합해서 홀수인 R, C를 저장할 것임
		ArrayList<Integer> r = new ArrayList<>();
		ArrayList<Integer> c = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			// 세로
			int sumR = 0;
			for(int j = 0; j < N; j++) {
				sumR += message[j][i];
			}
			if(sumR % 2 != 0) r.add(i + 1);
			
			// 가로
			int sumC = 0;
			for(int j = 0; j < N; j++) {
				sumC += message[i][j];
			}
			if(sumC % 2 != 0) c.add(i + 1);
		}

		// 아무것도 들어있지 않은 경우: 모든 행/열이 짝수 합
		if(r.size() == 0 && c.size() == 0) System.out.println("OK");
		// 행/열에 하나만 들어있는 경우: 둘의 좌표가 바꿀 패리티 비트가 됨
		else if(r.size() == 1 && c.size() == 1) System.out.println("Change bit (" + c.get(0) + "," + r.get(0) + ")");
		// 그렇지 않으면: 비트를 하나만 바꿔서는 만들 수 없음
		else System.out.println("Corrupt");
	}

}
