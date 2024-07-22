#include <bits/stdc++.h>
using namespace std;
#define INF 1e9

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

int n, l, r, a[54][54], visited[54][54], cnt, sum;
vector<pair<int, int>> v;

void dfs(int y, int x, vector<pair<int, int>> &v) {
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[ny][nx]) continue;
		if (l <= abs(a[y][x] - a[ny][nx]) && abs(a[y][x] - a[ny][nx]) <= r) {
			visited[ny][nx] = 1;
			sum += a[ny][nx];
			v.push_back({ny, nx});
			dfs(ny, nx, v);
		}
	}
}

int main() {
	cin >> n >> l >> r;
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> a[i][j];
		}
	}
	
	while(1) {
		bool flag = 0;
		fill(&visited[0][0], &visited[0][0] + 54 * 54, 0);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					v.clear();
					visited[i][j] = 1;
					sum = a[i][j];
					v.push_back({i, j});
					dfs(i, j, v);
					if (v.size() == 1) continue;
					flag = 1;
					for (auto k : v) {
						a[k.first][k.second] = sum / v.size();
					}
				}
			}
		}
		if (!flag) break;
		cnt++;
	}
	cout<< cnt << "\n";
	return 0;
}