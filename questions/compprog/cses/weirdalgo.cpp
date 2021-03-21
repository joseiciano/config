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

    ll n;
    cin >> n;
    cout << n;

    while (n != 1) {
        n = (n % 2 == 0) ? n >> 1 : n * 3 + 1;
        cout << " " << n;
    }

    return 0;
}

void solve() {}