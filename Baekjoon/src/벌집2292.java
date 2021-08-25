import java.util.Scanner;

public class 벌집2292 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		
		// 벌집의 둘레는 1 -> 6 -> 12 -> 18 -> ... 로 증가함.
		// 벌집의 값은   1 -> 7 -> 19 -> 25 -> ... 로 증가하는 누적합임.
		// 따라서 6의 배수를 계속 sum에 더하면서 결과값을 찾았다.
		int d = 1;
		int sum = 1;
		while(true) {
			if(N <= sum) break;
			sum += (6 * d);
			d++;
		}

		System.out.println(d);
	}

}
