#include <algorithm>
#include <iostream>

using namespace std;

#define ar array
#define ll long long

const int MAX_N = 1e5 + 1;
const int MOD = 1e9 + 7;
const int oo = 1e9;
const ll ool = 1e18;

int coins[101];
int dp[(int)1e6 + 1];

void solve() {
    int n, x;

    cin >> n >> x;

    for (int i = 0; i < n; i++)
        cin >> coins[i];

    sort(coins, coins + n);

    for (int i = 0; i <= x; i++)
        dp[i] = 0;

    dp[0] = 1;
    for (int i = 1; i <= x; i++)
        for (int j = 0; j < n; j++) {
            if (i - coins[j] < 0)
                break;

            dp[i] = (dp[i] + dp[i - coins[j]]) % MOD;
        }

    cout << dp[x] << "\n";
}

int main(void) {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    solve();

    return 0;
}