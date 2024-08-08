#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;

vector<int> a;
int n, m, ret = -INF;
string s;

void go(int val) {
	int cnt = 0;
	for (int i : a) {
		if ((i | val) == val) cnt++;
	}
	ret = max(ret, cnt);
}

int main() {
	cin >> n >> m;
	if (m < 5) {
		cout << 0;
		return 0;
	}
	
	int base = (1 << ('a' - 'a')) | (1 << ('c' - 'a')) | (1 << ('i' - 'a')) | (1 << ('n' - 'a')) | (1 << ('t' - 'a'));
	
	for (int i = 0; i < n; i++) {
		cin >> s;
		int alpa = 0;
		for (int j = 0; j < s.size(); j++) {
			alpa |= (1 << s[j] - 'a');
		}
		a.push_back(alpa);
	}
	
	for (int i = base; i < (1 << 26); i++) {
		if ((i & base) != base) continue;
		int cnt = 0;
		for (int j = 0; j < 26; j++) {
			if (i & (1 << j)) cnt++;
			if (cnt > m) break;
		}
		if (cnt == m) go(i);
	}
	
	cout << ret;
	
	return 0;
}