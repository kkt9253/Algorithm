#include <bits/stdc++.h>
using namespace std;

int n, a, b;
string s, ret;

int main() {
	cin >> n;
	
	while (n--) {
		cin >> s;
		a = 0;
		ret = "NO";
		for (int i = 0; i < s.size(); i++) {
			if (s[i] == '(') a++;
			else if (a == 0 && s[i] == ')') {
				a++;
				break;
			}
			else a--;
		}
		if (a == 0) ret = "YES";
		cout << ret << "\n";
	}
}