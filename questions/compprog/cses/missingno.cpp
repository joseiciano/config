#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
typedef unsigned long long ull;
typedef pair<ll, ll> pll;

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
#define foreach(a, b) for (auto &(a) : b)

const ll MOD = 1e9 + 7;
const ll INF = 1e9;
const double EPS = 1e-9;
const double PI = acos(-1);
const int dirx[8] = {-1, 0, 0, 1, -1, -1, 1, 1};
const int diry[8] = {0, 1, -1, 0, -1, 1, -1, 1};

int main(void) {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    ll n;
    cin >> n;
    ll exp = (n * (n + 1)) / 2;
    ll real = 0;

    for (ll i = 0; i < n; i++) {
        int b = 0;
        cin >> b;
        real += b;
    }

    cout << (exp - real) << endl;

    return 0;
}

void solve() {}