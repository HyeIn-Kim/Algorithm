import java.util.*;
class 가장큰수 {
    public String solution(int[] numbers) {
        String[] strs = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            strs[i] = Integer.toString(numbers[i]);
        }

        // 문자열 비교까지는 잘 생각했는데, 사전순 내림차순으로 정렬하면 3, 30이 아니라 30, 3으로 나와서 고생함
        // 풀이를 찾아보니 두 문자열을 붙여서 303, 330을 비교하여 해결할 수 있었다!
        Arrays.sort(strs, (o1, o2) -> (o2+o1).compareTo(o1+o2));

        if(strs[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }


        return sb.toString();
    }
}