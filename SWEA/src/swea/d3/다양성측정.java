package swea.d3;

import java.util.HashSet;
import java.util.Scanner;

public class 다양성측정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			String str = sc.next();
			HashSet<Character> set = new HashSet<>();
			int cnt = 0;
			
			for(int i = 0; i < str.length(); i++) {
				if(set.contains(str.charAt(i))) continue;
				cnt++;
				set.add(str.charAt(i));
			}
			
			System.out.println("#" + testCase + " " + cnt);
		}

	}

}
