#include <bits/stdc++.h>
using namespace std;
#define INF 1e9

int a, mx = -INF, mxIdx;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	for (int i = 1; i <= 9; i++) {
		cin >> a;
		if (mx < a) {
			mx = a;
			mxIdx = i;
		}
	}
	
	cout << mx << "\n" << mxIdx;
		
	return 0;
}