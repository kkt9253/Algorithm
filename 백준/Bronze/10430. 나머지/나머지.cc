#include <bits/stdc++.h>
using namespace std;

int a, b, c;
string s;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> a >> b >> c;
	int ret1 = (a + b) % c;
	int ret2 = ((a % c) + (b % c)) % c;
	int ret3 = (a * b) % c;
	int ret4 = ((a % c) * (b % c)) % c;
	
	cout << ret1 << "\n" << ret2 << "\n" << ret3 << "\n" << ret4 << "\n";
	return 0;
}