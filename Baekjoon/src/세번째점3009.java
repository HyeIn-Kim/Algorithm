import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 세번째점3009 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] inputX = new int[3];
		int[] inputY = new int[3];
		// 모든 입력값을 입력받고
		for(int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			inputX[i] = Integer.parseInt(st.nextToken());
			inputY[i] = Integer.parseInt(st.nextToken());
		}
		
		// 좌표 3개 중, 1개만 나온 좌표가 네번째 점의 x, y 좌표이다.
		int x = inputX[0];
		int y = inputY[0];
		
		// x좌표 비교
		if(inputX[0] == inputX[2]) x = inputX[1];
		if(inputX[0] == inputX[1]) x = inputX[2];
		
		// y좌표 비교
		if(inputY[0] == inputY[2]) y = inputY[1];
		if(inputY[0] == inputY[1]) y = inputY[2];
		
		// 출력
		System.out.println(x + " " + y);
	}

}
