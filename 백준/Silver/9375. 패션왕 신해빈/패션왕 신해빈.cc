#include <bits/stdc++.h>
using namespace std;

int tc, n;
string a, cate;

int main() {
	cin >> tc;
	while (tc--) {
		map<string, int> mp;
		cin >> n;
		for (int j = 0; j < n; j++) {
			cin >> a >> cate;
			mp[cate]++;
		}
		long long prod = 1;
		for (auto ele : mp) {
			prod *= ele.second + 1;	
		}
		cout << prod - 1 << "\n";
	}
	
	return 0;
}