import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 직사각형에서탈출1085 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        // (0,0)과 (w,h) 중에서 가장 가까운곳을 구해준다!
        int min = Integer.MAX_VALUE;
        min = Math.min(min, x);
        min = Math.min(min, y);
        min = Math.min(min, w - x);
        min = Math.min(min, h - y);
        System.out.println(min);
    }
}