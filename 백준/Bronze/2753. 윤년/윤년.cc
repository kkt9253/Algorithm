#include <bits/stdc++.h>
using namespace std;

int n, flag;

int main() {
	
	cin >> n;
	
	if (!(n % 4)) {
		if (!(n % 400)) flag = 1;
		else if (n % 100) flag = 1;
	}
	
	cout << flag;
	
	return 0;
}