#include <bits/stdc++.h>
using namespace std;
#define INF 1e9

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

int n, m, result = -1, visited[54][54];
char a[54][54];
string s;
vector<pair<int, int>> ground;

int bfs(int sy, int sx) {
    fill(&visited[0][0], &visited[0][0] + 54 * 54, 0);
    queue<pair<int, int>> q;
    q.push({sy, sx});
    visited[sy][sx] = 1;
    int mxdist = 0;

    while (!q.empty()) {
        int y, x;
        tie(y, x) = q.front();
        q.pop();

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx] || a[ny][nx] == 'W') continue;
            q.push({ny, nx});
            visited[ny][nx] = visited[y][x] + 1;
            mxdist = max(mxdist, visited[ny][nx]);
        }
    }
    return mxdist - 1; // 시작점을 포함하므로 1을 뺌
}

int main() {
    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) { // n 대신 m
            cin >> a[i][j];
            if (a[i][j] == 'L') {
                ground.push_back({i, j});
            }
        }
    }

    for (auto _ground : ground) {
        result = max(result, bfs(_ground.first, _ground.second));
    }

    cout << result << endl;
    return 0;
}
