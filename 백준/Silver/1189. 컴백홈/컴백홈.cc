#include <bits/stdc++.h>
using namespace std;

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

int r, c, k, a[9][9], visited[9][9], ret;
string s;

void dfs(int sy, int sx, int cnt) {
	if (cnt > k) return;
	if (sy == 0 && sx == c - 1) {
		if (cnt == k) {
			ret++;
			return;
		}
		return;
	}
	
	for (int i = 0; i < 4; i++) {
		int ny = sy + dy[i];
		int nx = sx + dx[i];
		if (ny < 0 || nx < 0 || ny >= r || nx >= c) continue;
		if (a[ny][nx] || visited[ny][nx]) continue;
		visited[ny][nx] = 1;
		dfs(ny, nx, cnt + 1);
		visited[ny][nx] = 0;
	}
	
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

	cin >> r >> c >> k;
	for (int i = 0; i < r; i++) {
		cin >> s;
		for (int j = 0; j < c; j++) {
			if (s[j] == '.') a[i][j] = 0;
			else a[i][j] = 1;
		}
	}
	
	visited[r - 1][0] = 1;
	dfs(r - 1, 0, 1);
	cout << ret;

    return 0;
}
