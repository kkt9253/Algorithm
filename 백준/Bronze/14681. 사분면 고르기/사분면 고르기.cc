#include <bits/stdc++.h>
using namespace std;

int n, m;

int main() {
	
	cin >> n >> m;
	
	if (n > 0) {
		if (m > 0) cout << 1;
		else cout << 4;
	} 
	else {
		if (m > 0) cout << 2;
		else cout << 3;
	}
	
	return 0;
}