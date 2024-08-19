#include <bits/stdc++.h>
using namespace std;

int n, m, k, val;

int main() {
	
	cin >> n >> m >> k;
	val = (n * 60) + m + k;
	
	if (val < 1440) {
		cout << (val / 60) << " " << (val % 60);
	}
	else {
		int temp = val - 1440;
		cout << (temp / 60) << " " << (temp % 60);
	}
	
	return 0;
}