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

    int n, x;
    cin >> n;
    cin >> x;

    int coins[n];
    fori(i, n) cin >> coins[i];

    ull dp[x + 1];
    for (int i = 0; i < x; i++) dp[i] = INF;

    dp[0] = 0;
    for (int i = 1; i < x + 1; i++) {
        for (int j = 0; j < n; j++) {
            if (coins[j] <= i) {
                dp[i] = min(dp[i], 1 + dp[i - coins[j]]);
            }
        }
    }

    cout << ((dp[x] == (x + 1)) ? -1 : dp[x]) << "\n";

    return 0;
}

void solve() {}