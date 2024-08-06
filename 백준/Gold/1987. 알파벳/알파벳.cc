#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

int n, m, visited, ret = -1;
char a[24][24];
string s;

void dfs(int sy, int sx, int cnt) {
	ret = max(ret, cnt);
	
	for (int i = 0; i < 4; i++) {
		int ny = sy + dy[i];
		int nx = sx + dx[i];
		if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
		if (visited & (1 << (a[ny][nx] - 'A'))) continue;
		visited |= (1 << (a[ny][nx] - 'A'));
		dfs(ny, nx, cnt + 1);
		visited &= ~(1 << (a[ny][nx] - 'A'));
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> s;
		for (int j = 0; j < m; j++) {
			a[i][j] = s[j];
		}
	}
	visited |= (1 << (a[0][0] - 'A'));
	dfs(0, 0, 1);
	
	cout << ret;
	
	return 0;
}
