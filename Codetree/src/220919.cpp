#include <iostream>
#include <queue>
using namespace std;

int main() {
    int n, m;
    priority_queue<int> pq;
    cin >> n >> m;
    for(int i = 0; i < n; i++) {
        int num;
        cin >> num;
        pq.push(num);
    }

    for(int i = 0; i < m; i++) {
        int num = pq.top();
        pq.pop();
        pq.push(num - 1);
    }

    cout << pq.top();
    return 0;
}

#include <iostream>
#include <queue>
#include <vector>
#include <functional>
using namespace std;

int main() {
    int n;
    cin >> n;

    priority_queue<int, vector<int>, greater<int>> pq;
    for(int i = 0; i < n; i++) {
        int value;
        cin >> value;

        if(value == 0) {
            if(pq.size() == 0) cout << 0 << endl;
            else {
                cout << pq.top() << endl;
                pq.pop();
            }
        }
        else pq.push(value);
    }
    return 0;
}

#include <iostream>
#include <set>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    set<int> s;
    for(int i = 0; i < n; i++) {
        int value;
        cin >> value;
        s.insert(value);
    }

    for(int i = 0; i < m; i++) {
        int value;
        cin >> value;

        auto it = s.upper_bound(value);
        if(s.begin() != it) {
            it--;
            cout << *it << endl;
            s.erase(*it);
        }
        else cout << -1 << endl;
    }
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;
    if(a < b) cout << 1 << " ";
    else cout << 0 << " ";

    if(a == b) cout << 1;
    else cout << 0;
    return 0;
}

#include <iostream>
using namespace std;

int main() {
    int a;
    cin >> a;

    if(a % 3 == 0) cout << "YES" << endl;
    else cout << "NO" << endl;

    if(a % 5 == 0) cout << "YES" << endl;
    else cout << "NO" << endl;
    return 0;
}