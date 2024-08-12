#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int INF = 1e9;

int dy[] = {0, -1, 0, 1};
int dx[] = {-1, 0, 1, 0};
int n, m, a[54][54], visited[54][54], roomN, roomM = -INF, ret = -INF, roomSize[2504];
// roomN : 성에 있는 방의 개수 , roomM : 가장 넓은 방의 넓이

int dfs(int sy, int sx, int count) {
	visited[sy][sx] = count;
	int cnt = 1;
	for (int i = 0; i < 4; i++) {
		if (!(a[sy][sx] & (1 << i))) { // 각 칸에 벽이 없는 방향이라면 
			int ny = sy + dy[i];
			int nx = sx + dx[i];
			if (ny < 0 || nx < 0 || ny >= m || nx >= n) continue;
			if (visited[ny][nx]) continue;
			cnt += dfs(ny, nx, count);
		}
	}
	return cnt;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			cin >> a[i][j];
		}
	}
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (!visited[i][j]) {
				roomN++;
				roomSize[roomN] = dfs(i, j, roomN);
				roomM = max(roomM, roomSize[roomN]);
			}
		}
	}
	
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (i + 1 < m) {
				int a = visited[i][j];
				int b = visited[i + 1][j];
				if (a != b) ret = max(ret, roomSize[a] + roomSize[b]);
			}
			if (j + 1 < n) {
				int a = visited[i][j];
				int b = visited[i][j + 1];
				if (a != b) ret = max(ret, roomSize[a] + roomSize[b]);
			}
		}
	}
	
	cout << roomN << "\n" << roomM << "\n" << ret;
	
	return 0;
}