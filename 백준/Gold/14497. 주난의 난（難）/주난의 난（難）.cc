#include <bits/stdc++.h>
using namespace std;

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

char a[304][304];
int n, m, visited[304][304], x, y, cnt;
pair<int, int> junan, crim;

void bfs(int sy, int sx) {
    queue<pair<int, int>> q;
    visited[sy][sx] = 1;
    q.push({sy, sx});
    while (q.size()) {
        tie(y, x) = q.front(); q.pop();
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (0 > ny || 0 > nx || nx >= m || ny >= n || visited[ny][nx]) continue;
            if (a[ny][nx] == '0') {
                visited[ny][nx] = visited[y][x];
                q.push({ny, nx});
            }
            else if (a[ny][nx] == '1' || a[ny][nx] == '#') {
            	visited[ny][nx] = visited[y][x] + 1;
            	a[ny][nx] = '0';
            }
        }
    }
    return;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> m >> junan.first >> junan.second >> crim.first >> crim.second;
    junan.first--; junan.second--; crim.first--; crim.second--;
    for (int i = 0; i < n; i++) {
    	for (int j = 0; j < m; j++) {
    		cin >> a[i][j];
		}
	}
	
	while (a[crim.first][crim.second] != '0') {
		fill(&visited[0][0], &visited[0][0] + 304 * 304, 0);
		cnt++;
    	bfs(junan.first, junan.second);
	}
    
    cout << cnt;
    
    return 0;
}
