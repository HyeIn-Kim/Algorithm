import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// DP 차원을 얼마나 쓸지 생각하는게 약한듯함.. 2차원 DP였다니!
public class LCS9251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1 = br.readLine();
		String input2 = br.readLine();
		
		int L1 = input1.length();
		int L2 = input2.length();
		// 인덱스 0을 처리하기 위해 1~N부터 시작
		int[][] LCS = new int[L1+1][L2+1];
		
		for(int i = 1; i <= L1; i++) {
			for(int j = 1; j <= L2; j++) {
				// 같은 수를 발견하면 (i-1, j-1) + 1을 해준다.
				if(input1.charAt(i-1) == input2.charAt(j-1)) {
					LCS[i][j] = LCS[i-1][j-1] + 1;
				}
				// LCS에 포함되지 않으면 (i-1, j)나 (i, j-1)중 최댓값으로 갱신해준다.
				else LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
			}
		}

		System.out.println(LCS[L1][L2]);
	}

}
