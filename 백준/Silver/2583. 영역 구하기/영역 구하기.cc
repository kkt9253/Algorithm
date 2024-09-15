#include <bits/stdc++.h>
using namespace std;
#define INF 1e9
typedef long long ll;

int dy[4] = {1, 0, -1, 0};
int dx[4] = {0, 1, 0, -1};
int m, n, k, a, b, c, d, ar[104][104], visited[104][104];
vector<int> ret;

int dfs(int sy, int sx) {
    int siz = 1;
    visited[sy][sx] = 1;
    
    for (int i = 0; i < 4; i++) {
        int ny = sy + dy[i];
        int nx = sx + dx[i];
        if (ny < 0 || ny >= m || nx < 0 || nx >= n || ar[ny][nx] || visited[ny][nx]) continue;
        siz += dfs(ny, nx);
    }
    
    return siz;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    cin >> m >> n >> k;
    
    while (k--) {
        cin >> a >> b >> c >> d;
        
        for (int i = b; i < d; i++) {
            for (int j = a; j < c; j++) {
                ar[i][j] = 1;
            }
        }
    }
    
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (!ar[i][j] && !visited[i][j]) {
                int area_size = dfs(i, j);
                ret.push_back(area_size);
            }
        }
    }
    
    sort(ret.begin(), ret.end());
    
    cout << ret.size() << "\n";
    for (int i : ret) cout << i << " ";
    
    return 0;
}
