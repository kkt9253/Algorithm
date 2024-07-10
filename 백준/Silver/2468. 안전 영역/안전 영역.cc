#include <bits/stdc++.h>
using namespace std;

int fy[] = {-1, 0, 1, 0};
int fx[] = {0, 1, 0, -1};

int ret=1, mx, n, adj[104][104], visited[104][104];

void dfs(int y, int x, int height) {
	visited[y][x] = 1;
	
	for (int i = 0; i < 4; i++) {
		int ny = y + fy[i];
		int nx = x + fx[i];
		if (0 > ny || 0 > nx || n <= ny || n <= nx) continue;
		if (!visited[ny][nx] && adj[ny][nx] > height) dfs(ny, nx, height);
	}
	return;
}
int main() {
	cin >> n;
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> adj[i][j];
		}
	}
	
	for (int h = 1; h <= 100; h++) {
		fill(&visited[0][0], &visited[0][0] + 104 * 104, 0);
		mx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && adj[i][j] > h) {
					dfs(i, j, h);
					mx++;	
				}
			}
		}
		ret = max(ret, mx);
	}
	cout << ret;
	
	return 0;
}