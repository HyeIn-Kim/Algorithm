import java.util.Stack;

public class 괄호변환 {
    public static String solution(String p) {
        // 빈 문자열이면 빈 문자열 반환
        if(p.equals("")) return "";
        // 올바른 문자열이면 입력 문자열 반환
        if(isRightString(p)) return p;

        int uIndex = findUIndex(p);
        String u = p.substring(0, uIndex);
        String v = p.substring(uIndex, p.length());

        if(isRightString(u)) return u + solution(v);
        else return "(" + solution(v) + ")" + reverse(u.substring(1, u.length() - 1));
    }

    private static String reverse(String u) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < u.length(); i++) {
            if(u.charAt(i) == '(') sb.append(")");
            else sb.append("(");
        }

        return sb.toString();
    }
    private static int findUIndex(String p) {
        int leftCnt = 0;
        int rightCnt = 0;
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') leftCnt++;
            else if(p.charAt(i) == ')') rightCnt++;

            if(leftCnt == rightCnt) return i + 1;
        }

        return p.length();
    }

    private static boolean isRightString(String p) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') stack.push('(');
            else {
                if(stack.isEmpty()) return false;
                else stack.pop();
            }
        }

        if(stack.isEmpty()) return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(solution("(()())()"));
        System.out.println(solution(")("));
        System.out.println(solution("()))((()"));
    }
}
