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
const int oo = 1e15;

signed main() {
    fast;

    int n, m;
    int u, v, w;
    vector<pii> g[MAX_N];
    vector<int> dist(MAX_N, oo);
    vector<int> vis(MAX_N, oo);

    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        cin >> u >> v >> w;
        g[u].pb({v, w});
    }

    priority_queue<pii, vector<pii>, greater<pii>> pq;
    dist[1] = 0;
    pq.push({0, 1});

    while (!pq.empty()) {
        pii cur = pq.top();
        pq.pop();

        if (!vis[cur.ss])
            continue;
        vis[cur.ss] = 0;

        for (auto &i : g[cur.ss]) {
            if (dist[i.ff] > cur.ff + i.ss) {
                dist[i.ff] = cur.ff + i.ss;
                pq.push({dist[i.ff], i.ff});
            }
        }
    }

    for (int i = 1; i <= n; i++)
        cout << dist[i] << " ";
}