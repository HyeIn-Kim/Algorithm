import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 나는친구가적다small_16171 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String keyword = br.readLine();
        input = input.replaceAll("[0-9]", "");

        System.out.println(input.contains(keyword) ? 1 : 0);
    }
}
