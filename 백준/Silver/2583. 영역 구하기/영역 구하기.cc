#include <bits/stdc++.h>
using namespace std;

int dy[] = {-1, 0, 1, 0}, dx[] = {0, 1, 0, -1};
int cnt, dfscnt, n, m, k, adj[104][104], visited[104][104];
vector<int> ret;

int dfs(int y, int x) {
	visited[y][x] = 1;
	int ret = 1;
	
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (0 > ny || 0 > nx || m <= ny || n <= nx) continue;
		if (!visited[ny][nx] && !adj[ny][nx]) {
			ret += dfs(ny, nx);
		}
	}
	return ret;
}

int main() {
    cin >> m >> n >> k;
    int lx, ly, rx, ry;
    while (k--) {
        cin >> lx >> ly >> rx >> ry;
        for (int i = ly; i < ry; i++) {
            for (int j = lx; j < rx; j++) {
                adj[m - 1 - i][j] = 1;
            }
        }
    }
    
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
        	if (!visited[i][j] && !adj[i][j]) {
        		ret.push_back(dfs(i, j));
			}
        }
    }
    
    sort(ret.begin(), ret.end());
    cout << ret.size() << "\n";
    for (int i : ret) cout << i << " ";
    
    return 0;
}
