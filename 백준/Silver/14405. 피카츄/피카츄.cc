#include <bits/stdc++.h>
using namespace std;

bool flag;
string s;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	
	cin >> s;
	
	for (int i = 0; i < s.size(); i++) {
		if (i < (s.size() - 1) && (s.substr(i, 2) == "pi" || s.substr(i, 2) == "ka")) i += 1;
		else if (i < (s.size() - 2) && s.substr(i, 3) == "chu") i += 2;
		else {
			flag = 1;
			break;
		}
	}
	if (flag) cout << "NO";
	else cout << "YES";
	
	return 0;
}