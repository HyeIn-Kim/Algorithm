import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class 패션왕신해빈9375 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			// key: 옷 종류 / value: 옷들 list
			HashMap<String, List<String>> map = new HashMap<String, List<String>>();
			// 입력
			for(int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				// 맵에 해당 옷 종류가 없으면 key 추가
				if(!map.containsKey(input[1])) {
					map.put(input[1], new ArrayList<String>());					
				}
				
				// 옷 리스트에 추가
				map.get(input[1]).add(input[0]);
			}
			
			// 옷은 한번에 여러종류 같이 입을 수 있으므로 * 연산 사용하므로 1부터
			int sum = 1;
			for(String s : map.keySet()) {
				// 1을 더해주는 이유는 이 옷을 안입는 경우도 포함하기 위해서.
				sum *= map.get(s).size() + 1;
			}
			
			// 그러면 최종적으로는 모든 옷을 안입는 경우도 1경우도 포함됨
			// 그래서 최종 결과에서는 1을 빼준다.
			sb.append((sum - 1) + "\n");
		}
		
		System.out.println(sb.toString());
	}

}
