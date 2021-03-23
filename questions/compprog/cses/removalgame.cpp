#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<ll, ll> pll;

#define input(x) cin >> x
#define ar array
#define fi first
#define se second
#define mp make_pair
#define pb push_back
#define permute next_permutation
#define sqr(x) ((ll)(x) * (x))
#define mem(a, b) memset(a, (b), sizeof(a))
#define all(x) x.begin(), x.end()
#define rall(x) x.end(), x.begin()
#define fori(i, n) for (int i = 0; i < (int)n; ++i)
#define forii(i, m, n) for (int i = (int)m; i < (int)n; ++i)
#define revfori(i, n) for (int i = (int)(n - 1); i >= 0; --i)
#define revforii(i, m, n) for (int i = (int)(n - 1); i >= (int)m; --i)
#define foreach(a, b) for (auto&(a) : b)

const ll MOD = 1e9 + 7;
const ll INF = 1e9;
const double EPS = 1e-9;
const double PI = acos(-1);
const int dirx[8] = {-1, 0, 0, 1, -1, -1, 1, 1};
const int diry[8] = {0, 1, -1, 0, -1, 1, -1, 1};

pair<ll, ll> dp[5001][5001];
ll pots[5001];

int main(void) {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int n;
    input(n);

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++) {
            dp[i][j] = mp(0, 0);
        }

    for (int i = 0; i < n; i++) {
        input(pots[i]);
    }

    // Array lengths of 1, only player 1 chooses
    for (int i = 0; i < n; i++) {
        dp[i][i].first = pots[i];
    }

    // Go diagonally down, level by level of subarray size
    for (int r = 2; r <= n; r++) {
        for (int i = 0; i <= n - 1; i++) {
            int j = i + r - 1;

            if (pots[i] + dp[i + 1][j].second > dp[i][j - 1].second + pots[j]) {
                dp[i][j].first = pots[i] + dp[i + 1][j].second;
                dp[i][j].second = dp[i + 1][j].first;
            } else {
                dp[i][j].first = dp[i][j - 1].second + pots[j];
                dp[i][j].second = dp[i][j - 1].first;
            }
        }
    }

    cout << dp[0][n - 1].first << " \n";

    return 0;
}