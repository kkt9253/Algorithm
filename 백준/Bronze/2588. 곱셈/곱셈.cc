#include <bits/stdc++.h>
using namespace std;

string a, b;
int c, d, e, f;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> a >> b;
	c = atoi(a.c_str());
	d = b[0] - '0';
	e = b[1] - '0';
	f = b[2] - '0';
	
	cout << (c * f) << "\n";
	cout << (c * e) << "\n";
	cout << (c * d) << "\n";
	cout << (c * atoi(b.c_str())) << "\n";
	
	return 0;
}