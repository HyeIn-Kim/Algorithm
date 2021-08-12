package swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 암호문3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int T = 1; T <= 10; T++) {
			int N = Integer.parseInt(br.readLine());
			LinkedList<Integer> list = new LinkedList<Integer>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int command = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				String c = st.nextToken();
				if(c.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int i = 0; i < y; i++) {
						int input = Integer.parseInt(st.nextToken());
						// x 다음 위치에 원소 삽입.
						// 원소를 삽입하면 크기가 늘어나기 때문에 순서를 유지하려면
						// x + i에 넣어야 함.
						list.add(x + i, input);
					}
				}
				else if(c.equals("D")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int i = 0; i < y; i++) {
						list.remove(x + 1);	// x의 다음 위치 원소 삭제
					}
				}
				else if(c.equals("A")) {
					int y = Integer.parseInt(st.nextToken());
					for(int i = 0; i < y; i++) {
						int input = Integer.parseInt(st.nextToken());
						list.add(input);
					}
				}
			}
			
			sb.append("#" + T + " ");
			for(int i = 0; i < 10; i++) {
				sb.append(list.get(i) + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
