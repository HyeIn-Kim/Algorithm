import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 직각삼각형4153 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			// 0이면 종료
			if(a == 0 && b == 0 && c == 0) break;
			
			// 변을 오름차순으로 정렬한 뒤
			int[] arr = {a * a, b * b, c * c};
			Arrays.sort(arr);
			
			// 가장 큰 변에 대해 피타고라스 정리(a^2 + b^2 = c^2)를 하면 끝
			sb.append(((arr[0] + arr[1] == arr[2]) ? "right" : "wrong") + "\n");
		}
		System.out.println(sb);
	}

}
