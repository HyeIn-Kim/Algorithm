import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 나머지3052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// set에 넣고
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0; i < 10; i++) {
			int input = Integer.parseInt(br.readLine());
			set.add(input % 42);
		}
		// 사이즈를 출력해주면 끝!
		System.out.println(set.size());
	}
}
