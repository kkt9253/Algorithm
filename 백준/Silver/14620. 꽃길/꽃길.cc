#include <bits/stdc++.h>
using namespace std;
#define prev tak
const int INF = 1e9;

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

int n, a[14][14], visited[14][14], ret = INF;

int cal() {
	int sum = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (visited[i][j]) sum += a[i][j];
		}
	}
	return sum;
}

bool check(int sy, int sx) {
	if (visited[sy][sx]) return 0;
	for (int i = 0; i < 4; i++) {
		int ny = sy + dy[i];
		int nx = sx + dx[i];
		if (visited[ny][nx]) return 0;
	}
	return 1;
}

void go(int cnt) {
	if (cnt == 3) {
		ret = min(ret, cal());
		return;
	}
	for (int i = 1; i < n - 1; i++) {
		for (int j = 1; j < n - 1; j++) {
			if (check(i, j)) {
				visited[i][j] = 1;
				for (int k = 0; k < 4; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					visited[ny][nx] = 1;
				}
				go(cnt + 1);
				visited[i][j] = 0;
				for (int k = 0; k < 4; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					visited[ny][nx] = 0;
				}
			}
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    cin >> n;
    for (int i = 0; i < n; i++) {
    	for (int j = 0; j < n; j++) {
    		cin >> a[i][j];
		}
	}
	
	go(0);
    cout << ret << "\n";
	return 0;	
}