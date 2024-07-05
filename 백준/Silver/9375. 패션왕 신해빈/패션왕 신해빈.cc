#include <bits/stdc++.h>
using namespace std;

int siz, tc, n;
string a, cate;
map<string, int> mp;

int main() {
	cin >> tc;
	for (int i = 0; i < tc; i++) {
		cin >> n;
		if (n == 0) {
			cout << "0" << "\n";
			continue;
		}
		for (int j = 0; j < n; j++) {
			cin >> a >> cate;
			mp[cate]++;
		}
		int prod = 1;
		for (auto ele : mp) {
			prod *= ele.second + 1;	
		}
		cout << prod - 1 << "\n";
		mp.clear();
	}
	
	return 0;
}