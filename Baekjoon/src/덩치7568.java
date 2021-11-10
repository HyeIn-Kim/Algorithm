import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 덩치7568 {

	// 덩치(키, 몸무게)를 비교할 클래스
	static class Person {
		int weight;
		int height;
		
		public Person(int weight, int height) {
			super();
			this.weight = weight;
			this.height = height;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 사람 수만큼 입력받고
		Person[] input = new Person[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			input[i] = new Person(weight, height);
		}
		
		StringBuilder sb = new StringBuilder();
		// 첫 사람부터 쭉 돌면서
		for(int i = 0; i < N; i++) {
			int cnt = 0;
			// 나보다 큰사람이 몇명 있는지 찾고
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				if(input[i].weight < input[j].weight
				&& input[i].height < input[j].height) cnt++;
			}
			// 순위는 1부터 시작하니까 1을 더해준다.
			sb.append((cnt + 1) + " ");
		}
		
		System.out.println(sb);
	}

}
