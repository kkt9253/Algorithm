#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

long long cnt[100004];
int n, k, visited[100004];
queue<int> q;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n >> k;
	
	if (n == k) {
		cout << 0 << "\n" << 1;
		return 0;
	}
	
	visited[n] = 1;
	cnt[n] = 1;
	q.push(n);
	while(q.size()) {
		int now = q.front();
		q.pop();
		
		for (int next : {now + 1, now - 1, now * 2}) {
			if (0 <= next && next < 100004) {
				if (!visited[next]) {
					q.push(next);
					visited[next] = visited[now] + 1;
					cnt[next] = cnt[now];
				}
				else if (visited[next] == visited[now] + 1) cnt[next] += cnt[now];
			}
		}
	}
	
	cout << visited[k] - 1 << "\n" << cnt[k];
	return 0;
}