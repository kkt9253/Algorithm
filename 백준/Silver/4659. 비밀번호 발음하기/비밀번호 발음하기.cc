#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

string s;

bool isVowel(int idx) {
	return (idx == 'a' || idx == 'e' || idx == 'i' || idx == 'o' || idx == 'u');
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	while (1) {
		cin >> s;
		if (s == "end") break;
		
		int includeV = 0, vcnt = 0, ccnt = 0, flag = 0, prev = -1;
		
		for (int i = 0; i < s.size(); i++) {
			int idx = s[i];
			if (isVowel(idx)) {
				includeV = 1;
				vcnt++; ccnt = 0;
			} else {
				vcnt = 0; ccnt++;
			}
			if (vcnt == 3 || ccnt == 3) {
				flag = 1; break;
			}
			if (i >= 1 && (idx == prev) && (idx != 'e' && idx != 'o')) {
				flag = 1;
				break;
			}
			prev = idx;
		}
		
		if (!includeV || flag) {
			cout << "<" << s << "> is not acceptable.\n";
		} else {
			cout << "<" << s << "> is acceptable.\n";
		}
	}
	return 0;
}