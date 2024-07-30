#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;
#define prev tak

int k, _end, a[1028];
vector<int> ret[14];

void go(int start, int end, int level) {
	if (start > end) return;
	
	if (start == end) {
		ret[level].push_back(a[start]);
		return;
	}
	
	int mid = (start + end) / 2;
	ret[level].push_back(a[mid]);
	
	go(start, mid - 1, level + 1);
	go(mid + 1, end, level + 1);
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> k;
	_end = (int)pow(2, k) - 1;
	for (int i = 0; i < _end; i++) {
		cin >> a[i];
	}
	
	go(0, _end, 1);
	
	for (int i = 1; i <= k; i++) {
		for (int j : ret[i]) {
			cout << j << " ";
		}
		cout << "\n";
	}
	 
	return 0;
}