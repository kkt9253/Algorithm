#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;

int n, a[24], ret = INF;
string s;

void go(int here) {
	if (here == n) {
		int sum = 0;
		for (int i = 1; i < (1 << n); i *= 2) {
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (a[j] & i) cnt++;
			}
			sum += min(cnt, n - cnt);
		}
		ret = min(ret, sum);
		return;
	}
	
	go(here + 1);
	a[here] = ~a[here];
	go(here + 1);
	
	return;
}

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> s;
		int k = 1;
		for (int j = 0; j < n; j++) {
			if (s[j] == 'T') a[i] |= k;
			k *= 2;
		}
	}
	
	go(0);
	cout << ret;
	
	return 0;
}