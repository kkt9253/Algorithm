#include <bits/stdc++.h>
using namespace std;

int n, a, b, cnt;
vector<int> ar;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a;
		ar.push_back(a);
	}
	
	cin >> b;
	
	for (int i : ar) {
		if (i == b) cnt++;
	}
	
	cout << cnt;
	
	return 0;
}