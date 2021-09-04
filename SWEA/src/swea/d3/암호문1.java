package swea.d3;

import java.util.LinkedList;
import java.util.Scanner;

public class 암호문1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		for(int testCase = 1; testCase <= 10; testCase++) {
			int N = sc.nextInt();
			// 중간 위치의 삽입/삭제가 편하도록 LinkedList를 사용하였다.
			LinkedList<Integer> list = new LinkedList<>();
			for(int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}
			
			int M = sc.nextInt();
			for(int i = 0; i < M; i++) {
				String command = sc.next();
				int start = sc.nextInt();
				int num = sc.nextInt();
				// 하나를 추가하면 문자열의 길이가 늘어나므로
				// start + j 위치에서 넣어주어야
				// start 다음에 숫자 num개를 삽입할 수 있음
				for(int j = 0; j < num; j++) {
					list.add(start + j, sc.nextInt());
				}
			}
			
			// 출력 부분
			sb.append("#" + testCase);
			for(int i = 0; i < 10; i++) {
				sb.append(" " + list.get(i));
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
