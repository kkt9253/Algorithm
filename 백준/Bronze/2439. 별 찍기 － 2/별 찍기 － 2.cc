#include <bits/stdc++.h>
using namespace std;

int n;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n;
	
	for (int i = 0; i < n; i++) {
		cout << string(n - i - 1, ' ') << string(i + 1, '*') << "\n";
	}
	
	
	return 0;
}