#include <bits/stdc++.h>
using namespace std;

int n;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n;
	
	for (int i = 0; i < n; i++) {
		int start = n - i - 1;
		for (int j = 0; j < n; j++) {
			if (j < start) cout << " ";
			else cout << "*";
		}
		cout << "\n";
	}
	
	
	return 0;
}
