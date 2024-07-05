#include <bits/stdc++.h>
using namespace std;

string s, ret;
char mid;
int flag, cnt[200];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> s;
	for (char a : s) cnt[a]++;
	
	for (int i = 'Z'; i >= 'A'; i--) {
		if (flag >= 2) break;
		if (cnt[i] & 1) {
			mid = (char)i;
			cnt[i]--;
			flag++;
		}
		for (int j = 0; j < cnt[i]; j += 2) {
			ret = (char)i + ret + (char)i;
		}
	}
	if (mid) ret.insert(ret.begin() + ret.size() / 2 , mid);
	if (flag == 2) cout << "I'm Sorry Hansoo" << "\n";
	else cout << ret << "\n";
	return 0;
}