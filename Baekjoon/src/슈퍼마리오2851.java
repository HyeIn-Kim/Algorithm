import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 슈퍼마리오2851 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		// 마리오는 한번 버섯을 안 먹으면 끝까지 못먹으므로
		// 판단을 위한 boolean 변수를 만들었음!
		boolean isStop = false;
		for(int i = 0; i < 10; i++) {
			int input = Integer.parseInt(br.readLine());
			// 이전 값과 현재 값중에서 누가 더 100이랑 가까운지 비교하고,
			// 현재 값이 더 가깝다면 sum에 더해줬다.
			if(!isStop && Math.abs(100 - sum) >= Math.abs(100 - (sum + input))) sum += input;
			else if(!isStop) isStop = true;
		}

		System.out.println(sum);
	}

}
