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
const double EPS = 1e-9;

int main(void) {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n;
    cin >> n;

    ull dp[n + 1];
    for (int i = 0; i < n + 1; i++) dp[i] = 0;

    dp[0] = 1;

    for (int i = 1; i < n + 1; i++)
        for (int j = 1; j < 7; j++)
            if (i - j >= 0)
                dp[i] = (dp[i] + dp[i - j]) % MOD;
    cout << dp[n] << "\n";

    return 0;
}

void solve() {}