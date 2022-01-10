import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 윤년2753 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int year = Integer.parseInt(br.readLine());
		boolean isLeapYear = false;
		
		// 윤년 조건에 맞게 구현하면 되는 문제!
		if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
				isLeapYear = true;
		}
		
		System.out.println((isLeapYear) ? 1 : 0);
	}

}
