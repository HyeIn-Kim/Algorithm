import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부분문자열6550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String input = br.readLine();
            if(input == null || input.equals("")) break;
            String[] string = input.split(" ");

            char[] keyword = string[0].toCharArray();
            char[] sentence = string[1].toCharArray();
            int pointer = 0;
            for(int i = 0; i < sentence.length; i++) {
                if(pointer == keyword.length) break;
                if(sentence[i] == keyword[pointer]) {
                    pointer++;
                }
            }

            sb.append(pointer == keyword.length ? "Yes" : "No").append("\n");
        }

        System.out.println(sb);
    }
}
