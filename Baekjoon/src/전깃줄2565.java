import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// LSI 응용문제 2.
// 연결되는 전깃줄 번호 순서대로 나열해보면..
// 8 2 9 1 4 6 7 10 --> 전체길이 = 8(N), LSI = 5
// 답은 전체길이 - LSI로 구할 수 있다.
public class 전깃줄2565 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// 우선 500개의 전봇대에 모두 입력받고
		int[] input = new int[501];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			input[index] = value;
		}
		
		// ArrayList에 순서대로 담아준다.
		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i = 1; i <= 500; i++) {
			if(input[i] != 0) numbers.add(input[i]);
		}
		
		int[] LSI = new int[N];
		int max = 0;
		for(int i = 0; i < N; i++) {
			LSI[i] = 1;
			for(int j = 0; j < i; j++) {
				if(numbers.get(j) < numbers.get(i) && LSI[j] + 1 > LSI[i]) {
					LSI[i] = LSI[j] + 1;
				}
			}
			max = Math.max(max, LSI[i]);
		}
		
		System.out.println(N - max);
	}

}
