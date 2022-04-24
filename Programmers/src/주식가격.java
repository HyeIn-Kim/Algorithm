import java.util.*;

class 주식가격 {
    class Stock {
        int price;
        int time;

        public Stock(int price, int time) {
            this.price = price;
            this.time = time;
        }
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int length = prices.length;
        Stack<Stock> stack = new Stack<>();
        for(int i = 0; i < length; i++) {
            while(!stack.isEmpty() && stack.peek().price > prices[i]) {
                Stock stock = stack.pop();
                answer[stock.time] = i - stock.time;
            }

            stack.push(new Stock(prices[i], i));
        }

        while(!stack.isEmpty()) {
            Stock stock = stack.pop();
            answer[stock.time] = length - stock.time - 1;
        }
        return answer;
    }
}