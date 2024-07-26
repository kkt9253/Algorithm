#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;
#define prev tak

int dy[] = {-1, 0, 1, 0};
int dx[] = {0, 1, 0, -1};

int n, k;
int visited[200004], prev[200004];
vector<int> v;
queue<int> q;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n >> k;
	
	if (n == k) {
		cout << 0 << "\n" << n;
		return 0;
	}
	
	visited[n] = 1;
	q.push(n);
	while (q.size()) {
		int here = q.front();
		q.pop();
		
		if (here == k) {
			cout << visited[here] - 1 << "\n";
			for (int i = k; i != n; i = prev[i]) {
				v.push_back(i);
			} v.push_back(n);
			reverse(v.begin(), v.end());
			for (int i : v) {
				cout << i << " ";
			}
			break;
		}
		
		for (int there : {here - 1, here + 1, here * 2}) {
			if (0 <= there && there < 200004) {
				if (!visited[there]) { // 첫방문
					visited[there] = visited[here] + 1;
					q.push(there);
					prev[there] = here;
				}
			}
		}
	}
	
	return 0;
}