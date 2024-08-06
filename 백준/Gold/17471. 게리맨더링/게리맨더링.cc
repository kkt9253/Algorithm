#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;

int n, a[14], m, k, comp[14], visited[14], ret = INF;
vector<int> v[14];

pair<int, int> dfs(int here, int val) {
	visited[here] = 1;
	pair<int, int> ret = {1, a[here]};
	for (int next : v[here]) {
		if (!visited[next] && comp[next] == val) {
			pair<int, int> temp = dfs(next, val);
			ret.first += temp.first;
			ret.second += temp.second;
		}
	}
	return ret;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0); cout.tie(0);
	
	cin >> n;
	for (int i = 1; i <= n; i++) cin >> a[i];
	for (int i = 1; i <= n; i++) {
		cin >> m;
		for (int j = 0; j < m; j++) {
			cin >> k;
			v[i].push_back(k);
		}
	}
	
	for (int i = 1; i < (1 << n) - 1; i++) {
		fill(&comp[0], &comp[0] + 14, 0);
		fill(&visited[0], &visited[0] + 14, 0);
		int idx1 = -1, idx2 = -1;
		for (int j = 0; j < n; j++) {
			if (i & (1 << j)) {
				comp[j + 1] = 1;
				idx1 = j + 1;
			} else idx2 = j + 1;
		}
		pair<int, int> comp1 = dfs(idx1, 1);
		pair<int, int> comp2 = dfs(idx2, 0);
		if (comp1.first + comp2.first == n) ret = min(ret, abs(comp1.second - comp2.second));
	}
	
	cout << (ret == INF ? -1 : ret) << "\n";
	
	return 0;
}