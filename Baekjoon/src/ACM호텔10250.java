import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ACM호텔10250 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase <= T; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			// N % H랑 N / H겠지~ 했는데 문제는
			// 호텔은 1 ~ H층, 1 ~ W번방인데
			// 나머지연산은 0 ~ H-1이고 나누기연산은 1 / W같은건 몫이 0이었다.
			// 그래서 if문을 두어서 상황에 맞게 출력해 주었다.
			if(N % H == 0) {
				System.out.printf("%d%02d\n", H, (N / H));				
			}
			else {
				System.out.printf("%d%02d\n", (N % H), (N / H) + 1);
			}
		}
	}

}
