import java.io.*;
import java.util.*;

public class 사는지역 {
    static class Person {
        String name;
        String addr;
        String city;

        public Person(String name, String addr, String city) {
            this.name = name;
            this.addr = addr;
            this.city = city;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            people[i] = new Person(st.nextToken(), st.nextToken(), st.nextToken());
        }

        Arrays.sort(people, (o1, o2) -> o2.name.compareTo(o1.name));
        System.out.println("name " + people[0].name);
        System.out.println("addr " + people[0].addr);
        System.out.println("city " + people[0].city);
    }
}


//#include <iostream>
//#include <string>
//using namespace std;
//
//class Bomb {
//    public:
//    string code;
//    char color;
//    int second;
//
//    Bomb(string code = "", char color = 'A', int second = 0) {
//        this->code = code;
//        this->color = color;
//        this->second = second;
//    }
//};
//
//int main() {
//        string code;
//        char color;
//        int second;
//        cin >> code >> color >> second;
//
//        cout << "code : " << code << "\n";
//        cout << "color : " << color << "\n";
//        cout << "second : " << second;
//        return 0;
//        }
//
//
//#include <iostream>
//using namespace std;
//
//class Product {
//    public:
//    string name;
//    int num;
//
//    Product(string name = "codetree", int num = 50) {
//        this->name = name;
//        this->num = num;
//    }
//};
//
//int main() {
//        string name;
//        int num;
//        cin >> name >> num;
//
//        Product p1 = Product();
//        Product p2 = Product(name, num);
//
//        cout << "product " << p1.num << " is " << p1.name << "\n";
//        cout << "product " << p2.num << " is " << p2.name << "\n";
//        return 0;
//        }