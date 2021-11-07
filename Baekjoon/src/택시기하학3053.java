import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 코드보다 개념이 더 어려웠던 문제..
// 택시 기하학 = 맨해튼 거리에서는 원이 원 모양이 아니라 정사각형 마름모꼴이다.
// 유클리드 기하학에서의 원의 넓이는 반지름 * 반지름 * 파이
// 여기서는 정사각형의 넓이를 구해주면 되는데, 나는 대각선으로 구했다.
// 입력으로 주어진 반지름 * 2 => 대각선, 대각선 * 대각선 / 2 = 마름모의 넓이
public class 택시기하학3053 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int R = Integer.parseInt(br.readLine());
		System.out.printf("%.6f\n", R * R * Math.PI);
		System.out.printf("%.6f\n", (double) (2 * R) * (2 * R) / 2);
	}

}
