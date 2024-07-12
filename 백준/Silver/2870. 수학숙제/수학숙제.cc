#include <bits/stdc++.h>
using namespace std;

int n;
string s, ret;
vector<string> v;

void go() {
	while(1) {
		if (ret.size() && ret.front() == '0') ret.erase(ret.begin());
		else break;
	}
	if (ret.empty()) ret = "0";
	v.push_back(ret);
	ret = "";
}

bool cmp(string a, string b) {
	if (a.size() == b.size()) return a < b;
	return a.size() < b.size();
}

int main() {
	cin >> n;
	
	while (n--) {
		cin >> s;
		ret = "";
		for (int i = 0; i < s.size(); i++) {
			if (s[i] < 'A') ret += s[i];
			else if (ret.size()) go();
		}
		if (ret.size()) go();
	}
	
	sort(v.begin(), v.end(), cmp);
	
	for (string i : v) cout << i << "\n";
	return 0;
}