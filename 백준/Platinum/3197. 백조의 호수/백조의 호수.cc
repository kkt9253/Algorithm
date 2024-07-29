#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int INF = 1e7;

int dy[4] = {-1, 0, 1, 0};
int dx[4] = {0, 1, 0, -1};

char a[1504][1504];
int n, m, swan_visited[1504][1504], water_visited[1504][1504], cnt, swanX, swanY;
string s;
queue<pair<int, int>> waterQ, swanQ, water_tempQ, swan_tempQ;

void clearQ(queue<pair<int, int>> &q) {
    queue<pair<int, int>> empty;
    swap(q, empty);
}

bool moveSwan() {
    while (!swanQ.empty()) {
        int sy, sx;
        tie(sy, sx) = swanQ.front(); swanQ.pop();
        for (int i = 0; i < 4; i++) {
            int ny = sy + dy[i];
            int nx = sx + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m || swan_visited[ny][nx]) continue;
            swan_visited[ny][nx] = 1;
            if (a[ny][nx] == 'L') return true;
            else if (a[ny][nx] == '.') swanQ.push({ny, nx});
            else if (a[ny][nx] == 'X') swan_tempQ.push({ny, nx});
        }
    }
    return false;
}

void meltIce() {
    while (!waterQ.empty()) {
        int sy, sx;
        tie(sy, sx) = waterQ.front(); waterQ.pop();
        for (int i = 0; i < 4; i++) {
            int ny = sy + dy[i];
            int nx = sx + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m || water_visited[ny][nx]) continue;
            if (a[ny][nx] == 'X') {
                water_visited[ny][nx] = 1;
                a[ny][nx] = '.';
                water_tempQ.push({ny, nx});
            }
        }
    }
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> s;
		for (int j = 0; j < m; j++) {
			a[i][j] = s[j];
			if (a[i][j] == '.' || a[i][j] == 'L') {
                water_visited[i][j] = 1;
                waterQ.push({i, j});
            }
			if (a[i][j] == 'L' && swanY == 0 && swanX == 0) {
				swanY = i;
				swanX = j;
			}
		}
	}
	
	swanQ.push({swanY, swanX});
	swan_visited[swanY][swanX] = 1;
	while (1) {
		if (moveSwan()) break;
		cnt++;
		meltIce();
		waterQ = water_tempQ;
		swanQ = swan_tempQ;
		clearQ(water_tempQ);
		clearQ(swan_tempQ);
	}
	
	cout << cnt;
	
	return 0;
}