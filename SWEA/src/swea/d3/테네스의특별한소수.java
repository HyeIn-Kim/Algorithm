package swea.d3;

import java.util.ArrayList;
import java.util.Scanner;

public class 테네스의특별한소수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		// 모든 testCase에서 쓸 수 있도록
		// 먼저 모든 A, B의 범위(1~1000000) 안의 소수를 구했다.
		int[] nest = new int[1000001];	// 소수 저장 배열
		
		nest[0] = 1; nest[1] = 1;	// 0과 1은 소수가 아님. 1처리
		// 에라토스테네스의 체 원리를 이용하여
		// 배수인 숫자들은 모두 1로 처리
		// 끝까지 다 돌면 0인 숫자들은 모두 소수
		for(int i = 2; i < nest.length; i++) {
			if(nest[i] == 1) continue;
			for(int j = i + i; j < nest.length; j += i) {
				nest[j] = 1;
			}
		}
		
		for(int testCase = 1; testCase <= T; testCase++) {
			int D = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			ArrayList<Integer> prime = new ArrayList<>();
			
			// A부터 B까지 소수 구하기
			for(int i = A; i <= B; i++) {
				if(nest[i] == 0) prime.add(i);
			}
			
			int cnt = 0;
			// 특별한 소수 구하기
			for(Integer p : prime) {
				while(p != 0) {
					// 각 자리에 D가 포함되었는지 검사하고
					// 포함되어있다면 cnt++하고 종료.
					// 다음 소수를 검사하러 감.
					if(D == p % 10) {
						cnt++;
						break;
					}
					p /= 10;
				}
			}
			sb.append("#" + testCase + " " + cnt + "\n");
		}
		System.out.println(sb);

	}

}
