#include <iostream>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;

    cout << (a % 2 == 0 ? "even" : "odd") << endl;
    cout << (b % 2 == 0 ? "even" : "odd");
    return 0;
}

#include <iostream>
#include <string>
#include <set>
using namespace std;

int main() {
    int n;
    cin >> n;

    set<int> set;

    for(int i = 0; i < n; i++) {
        string keyword;
        int value;
        cin >> keyword;

        if(keyword == "add") {
            cin >> value;
            set.insert(value);
        }
        else if(keyword == "remove") {
            cin >> value;
            set.erase(value);
        }
        else if(keyword == "find") {
            cin >> value;
            if(set.find(value) == set.end()) cout << "false" << endl;
            else cout << "true" << endl;
        }
        else if(keyword == "lower_bound") {
            cin >> value;
            if(set.end() == set.lower_bound(value)) cout << "None" << endl;
            else cout << *set.lower_bound(value) << endl;
        }
        else if(keyword == "upper_bound") {
            cin >> value;
            if(set.end() == set.upper_bound(value)) cout << "None" << endl;
            else cout << *set.upper_bound(value) << endl;
        }
        else if(keyword == "largest") {
            if(set.empty()) cout << "None" << endl;
            else cout << *set.rbegin() << endl;
        }
        else if(keyword == "smallest") {
            if(set.empty()) cout << "None" << endl;
            else cout << *set.begin() << endl;
        }
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

        if(value > *s.lower_bound(value)) cout << -1 << endl;
        else cout << *s.lower_bound(value) << endl;
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
    for(int i = 1; i <= m; i++) {
        s.insert(i);
    }

    for(int i = 0; i < n; i++) {
        int value;
        cin >> value;
        s.erase(value);
        cout << *s.rbegin() << endl;
    }

    return 0;
}

#include <iostream>
#include <set>
using namespace std;

int main() {
    int T;
    cin >> T;

    for(int testCase = 1; testCase <= T; testCase++) {
        int k;
        cin >> k;

        set<int> s;
        for(int i = 0; i < k; i++) {
            char cmd;
            int n;
            cin >> cmd >> n;

            switch(cmd) {
                case 'I': s.insert(n); break;
                case 'D':
                    if(s.empty()) break;
                    if(n == 1) s.erase(*s.rbegin());
                    else s.erase(*s.begin());
                    break;
            }
        }
        
        if(s.empty()) cout << "EMPTY" << endl;
        else cout << *s.rbegin() << " " << *s.begin() << endl;
    }
    
    return 0;
}

#include <iostream>
#include <set>
#include <utility>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    set<pair<int, int> > s;
    for(int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;
        s.insert(make_pair(x, y));
    }

    for(int i = 0; i < m; i++) {
        int x, y;
        cin >> x >> y;
        // pair의 첫번째 값의 lower bound, 값이 같다면 두번째 값의 lower bound를 반환
        pair<int, int> result = *s.lower_bound(make_pair(x, y));

        if(*s.end() == result) cout << "-1 -1" << endl;
        else cout << result.first << " " << result.second << endl;
    }
    return 0;
}