#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<ll, ll> pll;

#define fori(i, n) for (int i = 0; i < (int)n; ++i)
#define forii(i, m, n) for (int i = (int)m; i < (int)n; ++i)
#define revfori(i, n) for (int i = (int)(n - 1); i >= 0; --i)
#define revforii(i, m, n) for (int i = (int)(n - 1); i >= (int)m; --i)

const ll MOD = 1e9 + 7;
const ll INF = 1e9;

int main(void) {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    string s;
    cin >> s;

    ll n = 0;
    ll temp = 1;
    for (int i = 1; i < s.size(); i++) {
        if (s[i] == s[i - 1])
            temp += 1;
        else {
            n = max(n, temp);
            temp = 1;
        }
    }
    n = max(n, temp);
    cout << n << endl;

    return 0;
}

void solve() {}