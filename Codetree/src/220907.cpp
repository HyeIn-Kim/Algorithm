// 변수 사용
#include <iostream>
using namespace std;

int main() {
    int a = 97;
    int b = 13;

    cout << a << " - " << b << " = " << a - b;
    return 0;
}

// 다양한 자료형의 변수 선언하기
#include <iostream>
using namespace std;

int main() {
    int a = 3;
    char b = 'C';

    cout << a << endl;
    cout << b;
    return 0;
}

// 변수로 곱셈하기
#include <iostream>
using namespace std;

int main() {
    int a = 26;
    int b = 5;

    cout << a << " * " << b << " = " << a * b;
    return 0;
}

// 세 정수형 변수 선언
#include <iostream>
using namespace std;

int main() {
    int a = 7;
    int b = 23;
    int c = 30;

    cout << a << " + " << b << " = " << c;
    return 0;
}

// string 자료형을 사용할때는 반드시 string을 include
#include <iostream>
#include <string>
using namespace std;

int main() {
    int a = 3;
    string b = "C";
    cout << a << "..." << b;
    return 0;
}

// 변수 출력 2
#include <iostream>
using namespace std;

int main() {
    int a = 3;
    char b = 'C';
    cout << b << "!.....!" << a;
    return 0;
}

// 변수 출력 3
#include <iostream>
using namespace std;

int main() {
    int a = 1;
    int b = 2;
    char c = 'C';

    cout << a << "->" << b << "->" << c;
    return 0;
}


// 소수점 출력하기
#include <iostream>
using namespace std;

int main() {
    int weight = 13;
    double gravity = 0.165;

    // fixed = 소수점을 고정하겠다
    cout << fixed;
    cout.precision(6);
    cout << weight << " * " << gravity << " = " << weight * gravity;
    return 0;
}

// 반올림하기
#include <iostream>
using namespace std;

int main() {
    double a = 25.352;
    cout << fixed;
    // precision 안의 자릿수만큼 반올림하여 출력
    cout.precision(1);
    cout << a;
    return 0;
}

// 단위 변환
#include <iostream>
using namespace std;

int main() {
    double ft = 30.48;
    double mi = 160934;

    cout << fixed;
    cout.precision(1);
    cout << 9.2 << "ft = " << 9.2 * ft << "cm" << endl;
    cout << 1.3 << "mi = " << 1.3 * mi << "cm";
    return 0;
}