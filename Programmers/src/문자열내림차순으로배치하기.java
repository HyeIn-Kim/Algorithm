import java.util.*;
class 문자열내림차순으로배치하기 {
    public String solution(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);

        StringBuilder sb = new StringBuilder(new String(ch)).reverse();

        return sb.toString();
    }
}