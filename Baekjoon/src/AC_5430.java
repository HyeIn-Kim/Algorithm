import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 처음엔 배열을 다 뒤집어서 시간초과가 났는데,
// 덱의 성질을 잘 생각해보면 굳이 배열을 뒤집지 않아도 풀 수 있다!
// 1, 2, 3, 4 를 뒤집으면 4, 3, 2, 1
// 뒤집한 상태에서 첫번째 원소를 뽑음 = 안뒤집힌 상태에서 마지막 원소를 뽑음
// => boolean 변수로 뒤집혔는지 아닌지만 표시해서 상황에 맞게 앞/뒤에서 원소를 뽑으면 되는것!!
public class AC_5430 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			char[] p = br.readLine().toCharArray();
			int N = Integer.parseInt(br.readLine());
			Deque<Integer> deque = new ArrayDeque<>();
			String input = br.readLine();
			
			// 문자열 입력 처리가 조금 까다로웠다.
			// N이 0일때는 split 결과가 ""(빈 문자열)이 나왔기 때문..
			// 그래서 N이 0이 아닐때만 split으로 문자열을 나눠준 뒤, 덱에 넣기로 했음
			if(N != 0) {
				String[] numbers = input.substring(1, input.length()-1).split(",");
				
				for(int i = 0; i < numbers.length; i++) {
					deque.offer(Integer.parseInt(numbers[i]));
				}				
			}
			
			boolean isReverse = false;		// 뒤집혔는지 아닌지
			boolean isError = false;		// 에러인지 아닌지
			for(int i = 0; i < p.length; i++) {
				// R이 나오면 배열을 뒤집어주고
				if(p[i] == 'R') {
					isReverse = !isReverse;
				}
				// D가 나오면 지워주는데
				else if(p[i] == 'D') {
					// 크기가 0이면 지울 수 없으므로 에러.
					// 한번 에러가 나면 뒤는 볼 필요 없으므로 여기서 break 해주었음
					if(deque.size() == 0) {
						isError = true;
						break;
					}
					
					// 뒤집어져있으면 맨 뒤 원소를 빼고
					if(isReverse) deque.pollLast();
					// 아니라면 맨 앞 원소를 빼줌
					else deque.pollFirst();
				}
			}
			
			// 에러일 경우 에러 표시
			if(isError) { 
				sb.append("error\n");
			}
			else {
				sb.append("[");
				int size = deque.size();
				
				// 뒤집혀져 있으면 맨 뒤 원소들부터 출력
				if(isReverse) {
					while(!deque.isEmpty()) {
						sb.append(deque.pollLast() + ",");
					}
				}
				// 아니라면 맨 앞부터 차례대로 출력
				else {
					while(!deque.isEmpty()) {
						sb.append(deque.pollFirst() + ",");
					}
				}
				
				// 마지막 ,를 삭제하기 위해서 원소가 1개 이상일 때만 맨 뒤 ,를 지워줌
				if(size != 0) sb.setLength(sb.length()-1);
				sb.append("]\n");
			}
		}
		
		System.out.println(sb.toString());
	}

}
