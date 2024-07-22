#include <bits/stdc++.h>
using namespace std;
#define INF 1e9

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

int n, m, result = -1, a[54][54], visited[54][54];
string s;
vector<pair<int, int>> ground;

int bfs(int sy, int sx) {
	fill(&visited[0][0], &visited[0][0] + 54 * 54, 0);
	queue<pair<int, int>> q;
	q.push({sy, sx});
	visited[sy][sx] = 1;
	int mxdist = -1;
	
	while (q.size()) {
		tie(sy, sx) = q.front();
		q.pop();
		for (int i = 0; i < 4; i++) {
			int ny = sy + dy[i];
			int nx = sx + dx[i];
			if (ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx] || !a[ny][nx]) continue;
			q.push({ny, nx});
			visited[ny][nx] = visited[sy][sx] + 1;
			mxdist = max(mxdist, visited[ny][nx]);
		}
	}
	return mxdist - 1;
}

int main() {
	cin >> n >> m;
	
	for (int i = 0; i < n; i++) {
		cin >> s;
		for (int j = 0; j < m; j++) {
			if (s[j] == 'W') a[i][j] = 0;
			if (s[j] == 'L') {
				a[i][j] = 1;
				ground.push_back({i, j});
			}
		}
	}
	for (auto _ground : ground) {
		result = max(result, bfs(_ground.first, _ground.second));
	}
	
	cout << result;
	return 0;
}