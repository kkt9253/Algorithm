#include <bits/stdc++.h>
using namespace std;
#define prev tak

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

int n, m, cnt, cnt2;
int mp[104][104], visited[104][104];
vector<pair<int, int>> melt;

void dfs(int a, int b) {
	visited[a][b] = 1;
	if (mp[a][b] == 1) {
		melt.push_back({a, b});
		return;
	}
	
	for (int i = 0; i < 4; i++) {
		int ny = a + dy[i];
		int nx = b + dx[i];
		if (nx < 0 || ny < 0 || nx >= m || ny >= n || visited[ny][nx]) continue;
		dfs(ny, nx);
	}
	return;
}

int solve() {
	for (auto i : melt) {
		mp[i.first][i.second] = 0;
	}
	
	int chcnt = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (mp[i][j] == 1) chcnt++;
		}
	}
	return chcnt;
}

int main() {
	cin >> n >> m;
	
	for (int i = 0; i < n; i++) {
		for (int j= 0; j < m; j++) {
			cin >> mp[i][j];
		}
	}
	
	while (1) {
		fill(&visited[0][0], &visited[0][0]+ 104 * 104, 0);
		melt.clear();
		dfs(0, 0);
		cnt2 = melt.size();
		int chcnt = solve();
		cnt++;
		if (chcnt == 0) {
			break;
		}
	}
	
	cout << cnt << "\n" << cnt2;
	return 0;	
}