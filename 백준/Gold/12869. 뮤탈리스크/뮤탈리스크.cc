#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int INF = 1e7;

int n, a[3], visited[64][64][64];
int _a[6][3] = {
	{9, 3, 1},
	{9, 1, 3},
	{3, 9, 1},
	{3, 1, 9},
	{1, 3, 9},
	{1, 9, 3}
};
struct A {
	int a, b, c;
};

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	
	queue<A> q;
	visited[a[0]][a[1]][a[2]] = 1;
	q.push({a[0], a[1], a[2]});
	while(q.size()) {
		int a = q.front().a, b = q.front().b, c = q.front().c;
		if (a == 0 && b == 0 && c == 0) break;
		q.pop();
		for (int i = 0; i < 6; i++) {
			int na = max(0, a - _a[i][0]);
			int nb = max(0, b - _a[i][1]);
			int nc = max(0, c - _a[i][2]);
			if (visited[na][nb][nc]) continue;
			visited[na][nb][nc] = visited[a][b][c] + 1;
			q.push({na, nb, nc});
		}
	}
	cout << visited[0][0][0] - 1;
	
	return 0;
}