#include <bits/stdc++.h>
using namespace std;

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

char a[24][24];
int n, m, visited[30], ret;

void go(int sy, int sx, int cnt) {
	ret = max(ret, cnt);
	for (int i = 0; i < 4; i++) {
		int ny = sy + dy[i];
		int nx = sx + dx[i];
		if (0 > nx || 0 > ny || nx >= m || ny >= n) continue;
		int next = a[ny][nx] - 'A';
		if (!visited[next]) {
			visited[next] = 1;
			go(ny, nx, cnt + 1);
			visited[next] = 0;
		}
	}
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
    	for (int j = 0; j < m; j++) {
    		cin >> a[i][j];
		}
	}
	visited[a[0][0] - 'A'] = 1;
	go(0, 0, 1);
	
	cout << ret;
    return 0;
}