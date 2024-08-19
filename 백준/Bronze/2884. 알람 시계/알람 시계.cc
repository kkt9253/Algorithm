#include <bits/stdc++.h>
using namespace std;

int n, m, val;

int main() {
	
	cin >> n >> m;
	
	val = (n * 60) + m;
	
	int k = val - 45;
	
	if (k > 0) {
		cout << (k / 60) << " " << (k % 60);
	}
	else if (k < 0) {
		cout << "23 " << (60 + k);
	}
	else cout << "0 0";
	
	return 0;
}