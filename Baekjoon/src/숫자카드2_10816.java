import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// HashMap 사용 버전
public class 숫자카드2_10816 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < N; i++) {
			int key = Integer.parseInt(st.nextToken());
			// 같은 key를 map에 여러 번 넣으면 가장 마지막으로 넣은 값으로 변경된다.
			// getOrDefault?: 있으면 value, 없으면 default값을 반환
			// 입력받은 값을 map에 넣고 (중복값이 있을 경우 1씩 더해서)
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());
			// 꺼내주기만 하면 끝!
			sb.append(map.getOrDefault(key, 0) + " ");
		}
		
		System.out.println(sb.toString());
	}

}
