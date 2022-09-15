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