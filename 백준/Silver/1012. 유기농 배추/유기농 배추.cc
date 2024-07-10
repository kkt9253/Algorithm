#include <bits/stdc++.h>
using namespace std;

const int y[] = {-1, 0, 1, 0};
const int x[] = {0, 1, 0, -1};

int tc, n, m, k, xx, yy, ret;
int adj[51][51], visited[51][51];

void dfs(int sy, int sx) {
	visited[sy][sx] = 1;
	
	for (int i = 0; i < 4; i++) {
		int ny = sy + y[i];
		int nx = sx + x[i];
		if (0 > ny || 0 > nx || ny >= n || nx >= m) continue;
		if (!visited[ny][nx] && adj[ny][nx]) dfs(ny, nx);
	}
	return;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> tc;
	
	while (tc--) {
		fill(&adj[0][0], &adj[50][51], 0);
		fill(&visited[0][0], &visited[50][51], 0);
		
		cin >> m >> n >> k;
		for (int j = 0; j < k; j++) {
			cin >> xx >> yy;
			adj[yy][xx] = 1;
		}
		
		ret = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && adj[i][j]) {
					dfs(i, j);
					ret++;
				}
			}
		}
		
		cout << ret << "\n";
	}
	
	return 0;
}