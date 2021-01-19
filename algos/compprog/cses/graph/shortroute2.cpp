#include <algorithm>
#include <assert.h>
#include <bitset>
#include <deque>
#include <functional>
#include <iostream>
#include <iterator>
#include <limits>
#include <list>
#include <map>
#include <math.h>
#include <numeric>
#include <queue>
#include <set>
#include <sstream>
#include <stack>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <string>
#include <time.h>
#include <utility>
#include <vector>

using namespace std;

#define ar array
#define int long long
#define ff first
#define ss second
#define pii pair<int, int>
#define pb push_back
#define fast ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);

const int MAX_N = 1e5 + 5;
const int MOD = 1e9 + 7;
const int oo = 0x3f3f3f3f3f3f3f3fL;

signed main() {
    fast;

    int n, m, q;
    int u, v, w;
    cin >> n >> m >> q;

    int g[501][501];

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++)
            g[i][j] = oo;
        g[i][i] = 0;
    }

    while (m-- > 0) {
        cin >> u >> v >> w;
        u--;
        v--;
        g[u][v] = g[v][u] = min(g[u][v], w);
    }

    for (int k = 0; k < n; k++)
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                g[i][j] = g[j][i] = min(g[i][j], g[i][k] + g[k][j]);

    while (q-- > 0) {
        cin >> u >> v;
        u--;
        v--;

        if (g[u][v] == oo)
            cout << -1 << "\n";
        else
            cout << g[u][v] << "\n";
    }
}