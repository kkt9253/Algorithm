#include <bits/stdc++.h>
using namespace std;

int n, m, root, k;
vector<int> adj[54];

int dfs(int here) {
	int ret = 0;
	int child = 0;
	
	for (int there : adj[here]) {
		if (there == k) continue;
		ret += dfs(there);
		child++;
	}
	
	if (child == 0) return 1;
	return ret;
}

int main() {
	cin >> n;
	
	for (int i = 0; i < n; i++) {
		cin >> m;
		if (m == -1) root = i;
		else adj[m].push_back(i);
	}
	
	cin >> k;
	if (k == root) cout << "0";
	else cout << dfs(root);
	return 0;
}