package swea.d3;

import java.util.Scanner;

public class 쥬스나누기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt();
			
			// 첫 번째 사람이 자기가 원하는 만큼 주스를 다 따라 버린다면,
			// 첫 번째 사람은 자기가 따른 주스를 마지막 사람에게 뺏기게 되고,
			// 결국 첫 번째 사람은 가장 적은 양의 주스를 마실 수 있게 된다.
			// 그러니 모두가 최대 양으로 주스를 마시기 위해서는
			// 1/N씩 공평하게 따라야 한다는 걸 알 수 있음.
			sb.append("#" + testCase);
			for(int i = 1; i <= N; i++) {
				sb.append(" " + 1 + "/" + N);
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
