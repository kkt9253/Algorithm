#include <bits/stdc++.h>
using namespace std;

string s, ret;
int ssiz, c;

int main() {
	getline(cin, s);
	ssiz = s.size();
	
	for (int i = 0; i < ssiz; i++) {
		c = (s[i] + 13);
		
		if ('A' <= s[i] && s[i] <= 'Z') {
			if (c > 'Z') {
				c -= 26;
			}
			ret += c;
		} else if ('a' <= s[i] && s[i] <= 'z') {
			if (c > 'z') {
				c -= 26;
			}
			ret += c;
		} else ret += s[i];
	}
	cout << ret;
	return 0;
}