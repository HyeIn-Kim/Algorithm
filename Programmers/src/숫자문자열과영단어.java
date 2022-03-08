import java.util.*;
class 숫자문자열과영단어 {
    public int solution(String s) {
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i = 0; i < 10; i++) {
            s = s.replaceAll(numbers[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }
}