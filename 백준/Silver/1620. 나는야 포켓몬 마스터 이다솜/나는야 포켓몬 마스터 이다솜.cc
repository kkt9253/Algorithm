#include <bits/stdc++.h>
using namespace std;

int n, m, check;
map<string, int> mp1;
map<int, string> mp2;
string s;

int main() {
	cin >> n >> m;
	string ret[m];
	
	for (int i = 0; i < n; i++) {
		cin >> s;
		mp1[s] = i + 1;
		mp2[i + 1] = s;
	}
	
	for (int i = 0; i < m; i++) {
		cin >> s;
		check = atoi(s.c_str());
		// 문자열일 때 
		if (check == 0) {
			ret[i] = to_string(mp1[s]);
		} 
		// 정수일 때 
		else {
			ret[i] = mp2[check];
		}
	}
	for (string s : ret) cout << s << "\n";
	
	return 0;
}