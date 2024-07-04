#include <bits/stdc++.h>
using namespace std;

vector<char> checkv;
vector<char> v;
string s;
bool check = false;

int main() {
	int n;
	cin >> n;
	
	for (int i = 0; i < n; i++) {
		cin >> s;
		v.push_back(s[0]);
	}
	sort(v.begin(), v.end());
	for (char c : v) {
		auto it = find(checkv.begin(), checkv.end(), c);
		if (it != checkv.end()) {
			continue;
		}
		int a = lower_bound(v.begin(), v.end(), c) - v.begin();
		int b = upper_bound(v.begin(), v.end(), c) - v.begin();
		if (b - a >= 5) {
			checkv.push_back(c);
			cout << c;
			check = true;
		}
	}
	if (!check) cout << "PREDAJA";
	return 0;
}