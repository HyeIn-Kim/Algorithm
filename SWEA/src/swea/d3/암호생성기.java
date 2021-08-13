package swea.d3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 암호생성기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int T = 1; T <= 10; T++) {
			Queue<Integer> queue = new LinkedList<Integer>();
			int N = sc.nextInt();
			for(int i = 0; i < 8; i++) {
				queue.offer(sc.nextInt());
			}
			
			int i = 1;
			while(true) {
				int value = queue.poll() - i++;
				if(value <= 0) {
					value = 0;
					queue.offer(value);
					break;
				}
				
				queue.offer(value);
				
				if(i > 5) i = 1;
			}
			
			System.out.print("#" + T);
			for(Integer q : queue) {
				System.out.print(" " + q);
			}
			System.out.println();
		}
	}

}
