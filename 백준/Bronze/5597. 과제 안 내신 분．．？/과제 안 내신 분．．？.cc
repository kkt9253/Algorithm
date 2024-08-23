#include <bits/stdc++.h>
using namespace std;
#define INF 1e9

int ret, a;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	int n = 28;
	while (n--) {
		cin >> a;
		ret |= (1 << (a - 1));
	}
	
	int cnt = 0;
	for (int i = 0; i < 30; i++) {
		if (!(ret & (1 << i))) {
			cout << i + 1 << "\n";
			cnt++;
		}
		if (cnt >= 2) break;
	}
	
	return 0;
}