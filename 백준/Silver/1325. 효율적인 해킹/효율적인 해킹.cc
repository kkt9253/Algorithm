#include <bits/stdc++.h>
using namespace std;

int n, m, a, b, mx;
vector<int> v[10004];
vector<int> ret;

int bfs(int start) {
    int cnt = 0;
    vector<bool> visited(n + 1, false);
    queue<int> q;
    q.push(start);
    visited[start] = true;

    while (!q.empty()) {
        int cur = q.front();
        q.pop();
        cnt++;

        for (int i : v[cur]) {
            if (!visited[i]) {
                q.push(i);
                visited[i] = true;
            }
        }
    }

    return cnt;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m;
    for (int i = 0; i < m; i++) {
        cin >> a >> b;
        v[b].push_back(a);
    }

    for (int i = 1; i <= n; i++) {
        int cnt = bfs(i);
        if (cnt > mx) {
            mx = cnt;
            ret.clear();
            ret.push_back(i);
        } else if (cnt == mx) {
            ret.push_back(i);
        }
    }

    for (int i : ret) {
        cout << i << " ";
    }

    return 0;
}
