#include <bits/stdc++.h>
using namespace std;

int n, m, k, cnt;

int main() {
	
	cin >> n >> m >> k;
	int same = 0;
	if (n == m) {
		cnt++;
		same = n;
	}
	if (n == k) {
		cnt++;
		same = n;
	}
	if (k == m) {
		cnt++;
		same = m;
	}
	
	if (cnt == 1) {
		cout << (1000 + (same * 100));
	}
	else if (cnt == 3) {
		cout << (10000 + (same * 1000));
	}
	else {
		int v = max({n, m, k});
		cout << (v * 100);
	}
	return 0;
}