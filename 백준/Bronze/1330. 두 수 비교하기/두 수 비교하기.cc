#include <bits/stdc++.h>
using namespace std;

int n, m;

int main() {
	
	cin >> n >> m;
	
	if (n > m) cout << ">";
	else if (n < m) cout << "<";
	else cout << "==";
	
	return 0;
}