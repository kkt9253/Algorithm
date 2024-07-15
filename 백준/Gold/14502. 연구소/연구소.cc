#include <bits/stdc++.h>
using namespace std;

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

int n, m, a, mx = 0;
int mp[12][12], visited[12][12];
vector<pair<int, int>> virusList, wallList;

void dfs(int a, int b) {
	
	for (int i = 0; i < 4; i++) {
		int ny = a + dy[i];
		int nx = b + dx[i];
		if (nx < 0 || ny < 0 || nx >= m || ny >= n || mp[ny][nx] == 1 || visited[ny][nx]) continue;
		visited[ny][nx] = 1;
		dfs(ny, nx);
	}
	return;
}

int solve() {
	fill(&visited[0][0], &visited[0][0] + 12 * 12, 0);
	for (pair<int, int> i : virusList) {
		visited[i.first][i.second] = 1;
		dfs(i.first, i.second);
	}
	
	int cnt = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (mp[i][j] == 0 && !visited[i][j]) cnt++;
		}
	}
	
	return cnt;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> mp[i][j];
			if (mp[i][j] == 2) virusList.push_back({i, j});
			if (mp[i][j] == 0) wallList.push_back({i, j});
		}
	}
	
	for (int i = 0; i < wallList.size(); i++) {
		for (int j = 0; j < i; j++) {
			for (int k = 0; k < j; k++) {
				mp[wallList[i].first][wallList[i].second] = 1;
				mp[wallList[j].first][wallList[j].second] = 1;
				mp[wallList[k].first][wallList[k].second] = 1;
				mx = max(mx, solve());
				mp[wallList[i].first][wallList[i].second] = 0;
				mp[wallList[j].first][wallList[j].second] = 0;
				mp[wallList[k].first][wallList[k].second] = 0;
			}
		}
	}
	
	cout << mx << "\n";
	return 0;
}