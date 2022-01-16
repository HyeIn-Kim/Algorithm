import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 후위표기식1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] input = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < input.length; i++) {
            // 피연산자는 바로 출력
            if('A' <= input[i] && input[i] <= 'Z') sb.append(input[i]);
            else {
                // (: 스택에 push
                if(input[i] == '(') stack.push(input[i]);
                // ): (을 만날 때까지 스택을 pop
                else if(input[i] == ')') {
                    while(!stack.isEmpty() && stack.peek() != '(') sb.append(stack.pop());
                    if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                }
                // *, /: *, /(동일하거나 높은 우선순위)만 pop, (는 )이 pop해줄 것이므로 pop하지 않음
                else if(input[i] == '*' || input[i] == '/') {
                    while(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) sb.append(stack.pop());
                    stack.push(input[i]);
                }
                // +, -: +, -, *, /(동일하거나 높은 우선순위)만 pop, (는 )이 pop해줄 것이므로 pop하지 않음
                else if(input[i] == '+' || input[i] == '-') {
                    while(!stack.isEmpty() && stack.peek() != '(') sb.append(stack.pop());
                    stack.push(input[i]);
                }
            }
        }

        // stack에 연산자가 남아있다면 모조리 pop
        while(!stack.isEmpty()) {
            if(stack.peek() == '(') stack.pop();
            else sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
