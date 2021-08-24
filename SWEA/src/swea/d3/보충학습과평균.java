package swea.d3;
import java.util.Scanner;

public class 보충학습과평균 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int sum = 0;
			for(int i = 0; i < 5; i++) {
				int input = sc.nextInt();
				input = (input < 40) ? 40 : input;
				sum += input;
			}
			
			System.out.println("#" + testCase + " " + (sum/5));
		}

	}

}
