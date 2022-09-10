// 변수 swap
#include <iostream>
using namespace std;

int main() {
    int a = 2;
    int b = 5;
    int temp = a;
    a = b;
    b = temp;

    cout << a << endl;
    cout << b;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a = 5;
    int b = 6;
    int c = 7;
    int temp = a;
    a = c;
    c = b;
    b = temp;

    cout << a << endl;
    cout << b << endl;
    cout << c;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a = 1;
    int b = 2;
    int c = 3;

    a = b = c;
    cout << a << " " << b << " " << c;
    return 0;
}


#include <iostream>
using namespace std;

int main() {
    int a = 5;
    int b = 6;
    int c = 7;

    a = b = c;
    cout << a << " " << b << " " << c;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a = 1;
    int b = 2;
    int c = 3;

    a = b = c = a + b + c;
    cout << a << " " << b << " " << c;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a;
    cin >> a;
    cout << a + 2;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    cout << "Your score is " << n << " point.";
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a;
    cin >> a;
    cout << a * 2;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a;
    cin >> a;
    cout << a * 2 + 3;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    double n;
    cin >> n;
    cout << fixed;
    cout.precision(2);
    cout << n;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    double n;
    cin >> n;
    cout << fixed;
    cout.precision(1);
    cout << n * 30.48;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    double a;
    cin >> a;
    cout << fixed;
    cout.precision(2);
    cout << a + 1.5;
    return 0;
}

