#include <bits/stdc++.h>
using namespace std;
#define prev tak
const int INF = 1e9;

int n, h, m, f, s, a[34][14], ret = INF;

bool check() {
	for (int i = 1; i <= n; i++) {
		int start = i;
		for (int j = 1; j <= h; j++) {
			if (a[j][start]) start++;
			else if (a[j][start - 1]) start--;
		}
		if (start != i) return 0;
	}
	return 1;
}

void go(int start, int cnt) {
	if (cnt > 3 || cnt >= ret) return;
	if (check()) {
		ret = min(ret, cnt);
		return;
	}
	for (int i = start; i <= h; i++) {
		for (int j = 1; j < n; j++) {
			if (a[i][j] || a[i][j + 1] || a[i][j - 1]) continue;
			a[i][j] = 1;
			go(i, cnt + 1);
			a[i][j] = 0;
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    
    cin >> n >> m >> h;
    for (int i = 0; i < m; i++) {
    	cin >> f >> s;
    	a[f][s] = 1;
	}
	
	go(1, 0);
	cout << ((ret == INF) ? -1 : ret);
    
	return 0;	
}