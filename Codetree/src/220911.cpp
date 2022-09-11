#include <iostream>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;
    cout << a * b;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;
    cout << a + b;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;
    
    int temp = a;
    a = b;
    b = temp;
    cout << a << " " << b;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;
    cout << a << " " << b << " " << a + b;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a, b;
    // 입력이 여러줄일 때도 공백처럼 입력받음
    cin >> a >> b;
    cout << a * b;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;
    cout << a << " " << b;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    double a, b;
    cin >> a >> b;
    cout << fixed;
    cout.precision(2);
    cout << a + b;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    double a, b, c;
    cin >> a >> b >> c;
    cout << fixed;
    cout.precision(3);
    cout << a << endl;
    cout << b << endl;
    cout << c;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a, b, c;
    cin >> a >> b >> c;
    cout << a << " " << b << " " << c;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    char c;
    cin >> c;
    cout << c;
    return 0;
}

#include <iostream>
#include <string>
using namespace std;

int main() {
    string s;
    cin >> s;
    cout << s;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    char c;
    double a, b;
    
    cin >> c >> a >> b;

    cout << fixed;
    cout.precision(2);
    cout << c << endl;
    cout << a << endl;
    cout << b;
    return 0;
}

#include <iostream>
#include <string>
using namespace std;

int main() {
    string s, t;
    
    cin >> s >> t;
    cout << t << endl;
    cout << s;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int h, m;
    // char c;
    // cin >> h >> c >> m;

    cin >> h;
    cin.get();
    cin >> m;
    
    cout << h + 1 << ":" << m;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int y, d, m;
    char temp;

    cin >> m >> temp >> d >> temp >> y;
    cout << y << "." << m << "." << d;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int before, after;
    
    cin >> before;
    cin.get();
    cin >> after;

    cout << before << after;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int y, m, d;
    char temp;

    cin >> y >> temp >> m >> temp >> d;
    cout << m << "-" << d << "-" << y;
    return 0;
}

#include <iostream>
#include <string>
using namespace std;

int main() {
    int a, b, c;
    char temp;

    cin >> a >> temp >> b >> temp >> c;
    cout << 0 << a << "-" << c << "-" << b;
    return 0;
}

#include <iostream>
#include <string>
using namespace std;

int main() {
    int a, b, c;
    char temp;

    cin >> a >> temp >> b >> temp >> c;
    cout << 0 << a << "-" << c << "-" << b;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;
    cout << a + b << endl;
    cout << a - b << endl;
    cout << a / b << endl;
    cout << a % b;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;

    a += 8;
    b *= 3;
    cout << a << endl;
    cout << b << endl;
    cout << a * b;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;
    cout << a << " * " << b << " = " << a * b << endl;
    cout << a << " / " << b << " = " << a / b;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;
    cout << a / b << "..." << a % b;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;
    a += 87;
    b %= 10;
    cout << a << endl;
    cout << b;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;
    a += b;
    b += a;

    cout << a << " " << b;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;

    cout << fixed;
    cout.precision(2);
    cout << (double)(a + b) / (a - b);
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;

    cout << fixed;
    cout.precision(1);
    cout << a + b << " " << (double)(a + b) / 2;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a, b, c;
    cin >> a >> b >> c;
    cout << a + b + c << endl;
    cout << (a + b + c) / 3;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a, b, c;
    cin >> a >> b >> c;

    int sum = a + b + c;
    double avg = sum / 3.0;

    cout << sum << endl;
    cout << avg << endl;
    cout << sum - avg;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    cout << n << endl;

    if(n < 0) cout << "minus";
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a, b;
    
    cin >> a >> b;

    if(a > b) cout << a - b;
    else cout << b - a;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int height, weight;
    cin >> height >> weight;

    double m = (double)height / 100;
    int bmi = weight / (m * m);
    cout << bmi << endl;

    if(bmi >= 25) cout << "Obesity";
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    
    cout << n * n << endl;
    if(n < 5) cout << "tiny";
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int score;
    cin >> score;

    if(score >= 80) cout << "pass";
    else cout << 80 - score << " more score";
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a;
    cin >> a;

    if(a >= 113) cout << 1;
    else cout << 0;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;

    if(a > b) cout << a * b;
    else cout << b / a;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;

    cout << (a > b ? a : b);
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int score;
    cin >> score;

    cout << (score == 100 ? "pass" : "failure");
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a;
    cin >> a;

    cout << (a == 1 ? 't' : 'f');
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int temp;
    cin >> temp;

    if(temp < 0) cout << "ice";
    else if(temp >= 100) cout << "vapor";
    else cout << "water";
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    double eye;
    cin >> eye;

    if(eye >= 1.0) cout << "High";
    else if(eye >= 0.5) cout << "Middle";
    else cout << "Low";
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;

    if(n >= 3000) cout << "book";
    else if(n >= 1000) cout << "mask";
    else cout << "no";
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;

    if(n == 1) cout << "John";
    else if(n == 2) cout << "Tom";
    else if(n == 3) cout << "Paul";
    else cout << "Vacancy";
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int score;
    cin >> score;

    char grade;
    if(score >= 90) grade = 'A';
    else if(score >= 80) grade = 'B';
    else if(score >= 70) grade = 'C';
    else if(score >= 60) grade = 'D';
    else grade = 'F';

    cout << grade;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    char c;
    cin >> c;

    switch(c) {
        case 'S': cout << "Superior"; break;
        case 'A': cout << "Excellent"; break;
        case 'B': cout << "Good"; break;
        case 'C': cout << "Usually"; break;
        case 'D': cout << "Effort"; break;
        default: cout << "Failure";
    }
    return 0;
}