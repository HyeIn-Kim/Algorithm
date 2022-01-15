import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기적의매매법20546 {
    static class Person {
        int money;      // 남은 돈
        int cnt;        // 산 주식 수

        public Person(int money, int cnt) {
            this.money = money;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        Person a = new Person(money, 0);
        Person b = new Person(money, 0);

        int prev = 0;
        boolean isUp = true;
        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 14; i++) {
            int price = Integer.parseInt(st.nextToken());
            // 살 수 있다면 무조건 사는 A
            if(price <= a.money) {
                a.cnt += a.money / price;
                a.money = a.money % price;
            }

            // 연속 3일동안 가격이 올라갔는지 체크
            if(i != 0 && prev < price) {
                if(!isUp) {
                    isUp = true;
                    cnt = 0;
                }
                cnt++;
            }

            // 연속 3일동안 가격이 내려갔는지 체크
            if(i != 0 && prev > price) {
                if(isUp) {
                    isUp = false;
                    cnt = 0;
                }
                cnt++;
            }

            // 연속 3일동안 올라가면 있는거 다 팔기
            if(isUp && cnt == 3) {
                b.money += (price * b.cnt);
                b.cnt = 0;
            }

            // 연속 3일+@동안 올라가면 살 수 있는만큼 전부 사기
            if(!isUp && cnt >= 3) {
                if(price <= b.money) {
                    b.cnt += b.money / price;
                    b.money = b.money % price;
                }

            }

            prev = price;
        }

        int totalA = a.money + (a.cnt * prev);
        int totalB = b.money + (b.cnt * prev);
        if(totalA > totalB) System.out.println("BNP");
        else if(totalA < totalB) System.out.println("TIMING");
        else System.out.println("SAMESAME");
    }
}
