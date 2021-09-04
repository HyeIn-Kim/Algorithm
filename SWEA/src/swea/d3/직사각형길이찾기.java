package swea.d3;

import java.util.Scanner;

// 쉬운 문제였는데 여러가지 알고리즘 개념을 배우고 라이브러리를 쓰다 보니
// 처음엔 어렵게 생각했던 문제.
// 하지만 if문으로도 충분히 풀 수 있었다.
public class 직사각형길이찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			// 입력 3개가 주어졌을 때,
			// 직사각형의 나머지 한 변을 찾는 방법은 2가지가 있음.
			int result = 0;
			// 1. 정사각형일 때: 나머지 변도 a, b, c와 같음
			if(a == b && b == c) result = a;
			// 2. 직사각형일 때: 두 개의 같은 변을 찾고 남은 변이 나머지 변과 같음
			else if(a == b) result = c;
			else if(a == c) result = b;
			else if(b == c) result = a;
			
			sb.append("#" + testCase + " " + result + "\n");
		}
		System.out.println(sb);

	}

}
