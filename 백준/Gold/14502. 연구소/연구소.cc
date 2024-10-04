#include <bits/stdc++.h>
using namespace std;
#define INF 1e9

int dy[] = {1, 0, -1, 0};
int dx[] = {0, 1, 0, -1};

int n, m, adj[10][10], visited[10][10], ret;
vector<pair<int, int>> wallList, virus;
vector<int> v;

void go(int sy, int sx) {
	visited[sy][sx] = 1;
	
	for (int i = 0; i < 4; i++) {
		int ny = sy + dy[i];
		int nx = sx + dx[i];
		if (ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx] || adj[ny][nx]) continue;
		go(ny, nx);
	}
}

int safcnt() {
	int safe = 0;
	for (int i = 0; i < n; i++) {
    	for (int j = 0; j < m; j++) {
    		if (!visited[i][j] && adj[i][j] == 0) safe++;
		}
	}
	return safe;
}

void solve(int start) {
	if (v.size() == 3) {
		fill(&visited[0][0], &visited[0][0] + 10 * 10, 0);
		for (int vv : v) adj[wallList[vv].first][wallList[vv].second] = 1;
		for (auto vir : virus) go(vir.first, vir.second);
		ret = max(safcnt(), ret);
		for (int vv : v) adj[wallList[vv].first][wallList[vv].second] = 0;
		return;
	}
	for (int i = start + 1; i < wallList.size(); i++) {
		v.push_back(i);
		solve(i);
		v.pop_back();
	}
}

int main() {
	ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    cin >> n >> m;
    
    for (int i = 0; i < n; i++) {
    	for (int j = 0; j < m; j++) {
    		cin >> adj[i][j];
    		if (adj[i][j] == 0) wallList.push_back({i, j});
    		if (adj[i][j] == 2) virus.push_back({i, j});
		}
	}
	
	solve(-1);
	
	cout << ret;
	
	return 0;
}