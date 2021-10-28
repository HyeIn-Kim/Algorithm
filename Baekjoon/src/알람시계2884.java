import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 알람시계2884 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 입력받은 분이 45분보다 작으면 시간을 1 빼고 60분을 빌려온다.
		if(M < 45) {
			H -= 1;
			M += 60;
		}
		// 45분 빼줌
		M -= 45;
		
		// 만약 0시에서 1을 뺐다면 -1이 아니라 23시로 돌려준다.
		if(H < 0) H = 23;
		
		System.out.println(H + " " + M);
	}

}
